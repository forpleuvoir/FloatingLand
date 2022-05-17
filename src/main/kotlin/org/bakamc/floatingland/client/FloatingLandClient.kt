package org.bakamc.floatingland.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType.CLIENT
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient

/**
 * 客户端实例

 * 项目名 FloatingLand

 * 包名 org.bakamc.floatingland.client

 * 文件名 FloatingLandClient

 * 创建时间 2022/5/18 0:25

 * @author forpleuvoir

 */
@Environment(CLIENT)
object FloatingLandClient : ClientModInitializer {

	@JvmStatic
	val mc by lazy { MinecraftClient.getInstance() }

	override fun onInitializeClient() {

	}

}