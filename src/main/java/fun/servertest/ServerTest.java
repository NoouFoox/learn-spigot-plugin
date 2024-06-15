package fun.servertest;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ServerTest extends JavaPlugin {
    public static ServerTest main;

    @Override
    public void onLoad() {
//        生成配置文件 存在不生成
        saveDefaultConfig();
        main = this;
    }

    @Override
    public void onEnable() {
        // 打开触发
        Objects.requireNonNull(Bukkit.getPluginCommand("myplugin")).setExecutor(new Command());
//
        Bukkit.getPluginManager().registerEvents(new MyListener(),this);
        System.out.println("runrunrun哈哈哈");
    }

    @Override
    public void onDisable() {
        // 关闭触发
    }
}
