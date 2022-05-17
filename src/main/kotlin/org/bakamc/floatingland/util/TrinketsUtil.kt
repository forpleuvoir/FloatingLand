package org.bakamc.floatingland.util

import com.simibubi.create.AllItems
import dev.emi.trinkets.api.TrinketsApi
import net.minecraft.entity.LivingEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import java.util.function.Consumer

/**
 *

 * 项目名 FloatingLand

 * 包名 org.bakamc.floatingland.util

 * 文件名 TrinketsUtil

 * 创建时间 2022/5/18 0:27

 * @author forpleuvoir

 */
object TrinketsUtil {

	/**
	 * 实体是否装备指定饰品
	 * @receiver LivingEntity
	 * @param item Item
	 * @param itemStackConsumer Consumer<ItemStack> 如果装备则执行回调
	 */
	@JvmStatic
	fun LivingEntity.hasItem(item: Item, itemStackConsumer: Consumer<ItemStack>) {
		TrinketsApi.getTrinketComponent(this).map { trinketComponent ->
			if (trinketComponent.isEquipped(item)) {
				trinketComponent
					.getEquipped(AllItems.COPPER_BACKTANK.get())
					.stream()
					.findFirst()
					.ifPresent {
						itemStackConsumer.accept(it.right)
					}
			}
		}
	}
}