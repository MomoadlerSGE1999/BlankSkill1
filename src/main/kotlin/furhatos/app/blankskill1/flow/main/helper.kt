import furhatos.flow.kotlin.Furhat
import furhatos.util.Language

fun Furhatask (furhat:Furhat, englishText: String, romanianText: String, germanText: String, sprache: Language) {
    if (sprache == Language.ENGLISH_US) {
        furhat.ask(text=englishText)
    }
    if (sprache == Language.ROMANIAN) {
    furhat.ask(text=romanianText)
    }

    else {
        furhat.ask(text=germanText)
    }
}

fun Furhatsay (furhat:Furhat, englishText: String, romanianText: String, germanText: String, sprache: Language) {
    if (sprache == Language.ENGLISH_US) {
        furhat.say(text=englishText)
    }
    if (sprache == Language.ROMANIAN) {
        furhat.say(text=romanianText)
    }

    else {
        furhat.say(text=germanText)
    }
}