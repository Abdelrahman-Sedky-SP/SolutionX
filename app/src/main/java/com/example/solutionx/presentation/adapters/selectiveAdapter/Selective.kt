package com.example.solutionx.presentation.adapters.selectiveAdapter

sealed interface Selective {
    interface DeleteClickListener : Selective {
        fun onDeleteClicked(item: String)
    }

    interface EditClickListener : Selective {
        fun onEditClicked(item: String)
    }

    interface FavoriteListener : Selective {
        fun onFavoriteClicked(item: String)
    }
}