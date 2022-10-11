package net.gorayan.adventure.kx

import net.kyori.adventure.text.Component

fun planeText(content: String): Component {

    return Component.text(content).white().clearDecorations()

}

fun text(content: String): Component = Component.text(content)

fun emptyText() = Component.empty()

fun spaceText() = Component.space()