/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

interface MyActivityCallback {
    fun goToEvent(event: Event)

    fun toggleFavorite(position: Int)
}