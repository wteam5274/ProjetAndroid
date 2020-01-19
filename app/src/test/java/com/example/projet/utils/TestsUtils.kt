package com.example.projet.utils

import com.example.projet.data.models.Screen

class TestsUtils {
    companion object {

        fun generateOnBoardingEntityList(): List<Screen> {
            return (0..4).map {
                Screen(
                    id = it,
                    title = "Screen$it",
                    description = "Desc$it",
                    screenImg = "Img$it"
                )
            }
        }
    }


}