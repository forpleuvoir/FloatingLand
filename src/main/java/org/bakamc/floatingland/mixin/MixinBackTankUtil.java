package org.bakamc.floatingland.mixin;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.curiosities.armor.BackTankUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.bakamc.floatingland.util.TrinketsUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


/**
 * 项目名 baka-old-fabric
 * <p>
 * 包名 org.bakamc.mixin.create
 * <p>
 * 文件名 MixinBackTankUtil
 * <p>
 * 创建时间 2022/4/9 16:17
 *
 * @author forpleuvoir
 */
@Mixin(value = BackTankUtil.class, remap = false)
public abstract class MixinBackTankUtil {
	@Inject(method = "get", at = @At("HEAD"), cancellable = true)
	private static void get(LivingEntity entity, CallbackInfoReturnable<ItemStack> cir) {
		TrinketsUtil.hasItem(entity, AllItems.COPPER_BACKTANK.get(), itemStack -> {
			cir.setReturnValue(itemStack);
			cir.cancel();
		});
	}
}
