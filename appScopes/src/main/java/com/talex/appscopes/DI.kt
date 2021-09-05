package com.talex.appscopes

import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module

object DI {
    lateinit var appScope: Scope

    fun createAppScope(vararg modules: Module) {
        appScope = Toothpick.openScope("APP").apply {
            installModules(*modules)
        }
    }
}
