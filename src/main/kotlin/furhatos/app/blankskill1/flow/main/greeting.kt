package furhatos.app.blankskill1.flow.main

import Furhatask
import Furhatsay
import furhatos.app.blankskill1.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes
import furhatos.records.User
import furhatos.util.Language

var Benutzer: User? = null

val Greeting: State = state(Parent) {
    onEntry {
        furhat.ask("Welche Sprache sprichst du am liebsten")
    }

    onResponse {
        Benutzer = users.current
        furhat.say("Hello World ${it.speech.language.code} ")
        furhat.say("${it.language}")


        var sprachcode: Language? = it.language
        Benutzer!!.put("sprache", sprachcode)

       goto(GreetinginLanguageX)
    }

}

val GreetinginLanguageX: State = state(Parent) {

    onEntry {
        if (Benutzer != null) {
            Furhatask(furhat = this.furhat, englishText = "Okay, then we continue in english", romanianText = "Bine, atunci să trecem la limba română",
                germanText = "Okay dann machen wir weiter in deutsch", sprache= Benutzer!!.get("sprache") as Language
            )
        }
    }
    onResponse<Yes> {
        Furhatsay(furhat=this.furhat, englishText = "Fine I like to continue in english", romanianText = "Ei bine, continuați în limba română",
            germanText = "Gut, deutsch spreche ich auch gerne", sprache = Benutzer!!.get("sprache") as Language)
    }
    onResponse<No> {
        Furhatsay(furhat=this.furhat, englishText = "Fine I like to continue in english", romanianText = "Ei bine, continuați în limba română",
            germanText = "Gut, deutsch spreche ich auch gerne", sprache = Benutzer!!.get("sprache") as Language)
    }

}

