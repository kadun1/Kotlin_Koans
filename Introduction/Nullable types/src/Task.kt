fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    val email: String? = client?.personalInfo?.email

    if (email == null || message == null) return

    return mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}
