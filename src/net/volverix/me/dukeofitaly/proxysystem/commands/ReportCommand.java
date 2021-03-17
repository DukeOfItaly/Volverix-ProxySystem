package net.volverix.me.dukeofitaly.proxysystem.commands;


import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ReportCommand extends Command {

    public ReportCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 2) {
            String reason = args[1];
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            if (reason.equalsIgnoreCase())
        }
    }
}
