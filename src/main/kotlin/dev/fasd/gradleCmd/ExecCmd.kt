package dev.fasd.gradleCmd

import org.gradle.api.Project
import java.io.ByteArrayOutputStream
import java.lang.Exception

object ExecCmd {
    //Символ, разделитель команд
    const val CMD_SEPARATE = ' '
}

/**
 * Выполнение команды
 * <p>
 * Выполнит полную команду разделяя ее на аргументы через разделитель [ExecCmd.CMD_SEPARATE]
 *
 * @return Вернет результат исполнения
 */
fun Project.execCmd(command: String): String {
    val args = command.split(ExecCmd.CMD_SEPARATE).toTypedArray()
    return project.execArgs(*args)
}

/**
 * Исполняет внешние команды поданные на вход
 * <p>
 * @param args набор команд или по иному аргументов, те команда '''git branch''' это два аргумента
 * [git, branch]
 *
 * @return Вернет результат исполнения, сопостовимо с тем что выведит команда в консоль
 */
fun Project.execArgs(vararg args: String): String {
    val output = ByteArrayOutputStream()
    try {
        exec {
            commandLine(args.toList())
            standardOutput = output
        }

        return output.toString().trim()
    } catch (ex: Exception) {
        val result = output.toString().trim()
        System.err.println("""
            |ERROR_EXEC_CMD - RES_MSG: $result, 
            |ARGS: ${args.joinToString(prefix = "[", postfix = "]")}, 
            |EXCEPTION - $ex, CAUSE - ${ex.cause}
            |""".trimMargin())
        throw ex
    }
}