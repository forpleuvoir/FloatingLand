package org.bakamc.floatingland.mixin;

import com.simibubi.create.content.curiosities.armor.CopperArmorItem;
import com.simibubi.create.content.curiosities.armor.DivingHelmetItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
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
 * 文件名 MixinCopperArmorItem
 * <p>
 * 创建时间 2022/4/9 17:01
 *
 * @author forpleuvoir
 */
@Mixin(value = CopperArmorItem.class, remap = false)
public abstract class MixinCopperArmorItem {

	@SuppressWarnings("all")
	@Inject(method = "isWornBy", at = @At("HEAD"), cancellable = true)
	public void isWornBy(Entity entity, CallbackInfoReturnable<Boolean> cir) {
		if (entity instanceof LivingEntity livingEntity && (CopperArmorItem) (Object) this instanceof DivingHelmetItem divingHelmetItem) {
			TrinketsUtil.hasItem(livingEntity, divingHelmetItem, itemStack -> {
				cir.setReturnValue(true);
				cir.cancel();
			});
		}
	}
}
