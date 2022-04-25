package com.tfl.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.tfl.shoppinglist.data.ShopListRepositoryImpl
import com.tfl.shoppinglist.domain.DeleteShopItemUseCase
import com.tfl.shoppinglist.domain.EditShopItemUseCase
import com.tfl.shoppinglist.domain.GetShopListUseCase
import com.tfl.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(shopItem)
    }
}