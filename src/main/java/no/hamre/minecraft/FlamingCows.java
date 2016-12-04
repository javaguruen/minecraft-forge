package no.hamre.minecraft;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class FlamingCows implements ICommand {
    private List aliases = new ArrayList();
    private int numberOfCows = 0;

    public FlamingCows() {
        aliases.add("flamingcows");
        aliases.add("fc");
    }

    @Override
    public String getName() {
        return "flamingcows";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/flamingcows <number of cows>";
    }

    @Override
    public List getAliases() {
        return aliases;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void execute(ICommandSender sender, String[] args) {
        if (args.length != 1) {
            sendErrorMessage(sender, "Invalid number of arguments!");
            return;
        }
        try {
            numberOfCows = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            sendErrorMessage(sender, "The argument \"" + args[0] +
                    "\" is not a valid number!");
            return;
        }
        EntityPlayer player = (EntityPlayer) sender;
        for (int i = 0; i < numberOfCows; i++) {
            EntityCow cow = new EntityCow(player.worldObj);
            cow.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
            cow.setFire(10000);
            player.worldObj.spawnEntityInWorld(cow);
        }
    }

    private void sendErrorMessage(ICommandSender sender, String message) {
        sender.addChatMessage(new ChatComponentText(
                EnumChatFormatting.DARK_RED + message));
    }

    @Override
    public boolean canCommandSenderUse(ICommandSender sender) {
        return sender instanceof EntityPlayer;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender,
                                        String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }
}
