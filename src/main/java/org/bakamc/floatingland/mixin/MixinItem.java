package org.bakamc.floatingland.mixin;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.curiosities.armor.BackTankUtil;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

/**
 * 项目名 baka-old-fabric
 * <p>
 * 包名 org.bakamc.mixin.create
 * <p>
 * 文件名 MixinItem
 * <p>
 * 创建时间 2022/4/9 17:35
 *
 * @author forpleuvoir
 */
@Mixin(Item.class)
public abstract class MixinItem {
	@Inject(method = "appendTooltip", at = @At("HEAD"))
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
		if (stack.getItem() == AllItems.COPPER_BACKTANK.get()) {
			int maxAir = BackTankUtil.maxAir(stack);
			int air = (int) BackTankUtil.getAir(stack);
			tooltip.add(new TranslatableText("floatingland.create.copper_backtank.air", air, maxAir));
		}
	}
}
