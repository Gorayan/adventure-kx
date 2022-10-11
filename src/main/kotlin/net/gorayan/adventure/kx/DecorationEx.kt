package net.gorayan.adventure.kx

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextDecoration

fun Component.bold(): Component = decorate(TextDecoration.BOLD)
fun Component.italic(): Component = decorate(TextDecoration.ITALIC)
fun Component.underline(): Component = decorate(TextDecoration.UNDERLINED)
fun Component.strikethrough(): Component = decorate(TextDecoration.STRIKETHROUGH)
fun Component.obfuscated(): Component = decorate(TextDecoration.OBFUSCATED)


private val planeDecorations = TextDecoration.values().associateWith { TextDecoration.State.FALSE }

fun Component.clearDecorations(): Component = decorations(planeDecorations)