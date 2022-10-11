package net.gorayan.adventure.kx

import net.kyori.adventure.text.Component

operator fun Component.plus(component: Component) = append(component)

fun combine(vararg components: Component): Component {

    var base: Component = emptyText()

    components.forEach { base += it }

    return base

}

fun multiline(vararg components: Component): Component {

    var base: Component = emptyText()

    val size = components.size

    components.forEachIndexed { index, component ->

        base += component

        if (index != size - 1) {

            base += Component.newline()

        }

    }

    return base

}