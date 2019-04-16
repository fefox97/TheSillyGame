package com.example.thesillygame

import kotlin.properties.Delegates

// è un singleton che serve ad osservare i cambiamenti di una variabile

object ValueChanged {
    var refreshListListeners = ArrayList<() -> Unit>()

    // fires off every time value of the property changes
    var nmosse: Int by Delegates.observable(0) { property, oldValue, newValue ->
        // do your stuff here
        refreshListListeners.forEach {
            it()
        }
    }
    var nvittorie: Int by Delegates.observable(0) { property, oldValue, newValue ->
        // do your stuff here
        refreshListListeners.forEach {
            it()
        }
    }

    var vittoria: Boolean by Delegates.observable(false) { property, oldValue, newValue ->
        // do your stuff here
        refreshListListeners.forEach {
            it()
        }
    }
}