package com.pedro.tag.api;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.pedro.tag.Main;

public class DataManager {
	
	public static void createFolder(String folder) {
		try {
			File pasta = new File(Main.getInstance().getDataFolder() + File.separator + folder);
			if (!pasta.exists()) {
				pasta.mkdirs();
			}
		}catch (Throwable e) {
			Main.getInstance().getLogger().info("PedroTags - Erro ao criar a pasta: " + folder + ".");
			e.printStackTrace();
		}
	}

	public static void createFile(File file) {
		try {
			file.createNewFile();
			
		}catch (Throwable e) {
			Main.getInstance().getLogger().info("PedroTags - Erro ao criar a arquivo: " + file.getName() + ".");
			e.printStackTrace();
		}
	}
	
	public static File getFolder(String folder) {
		File Arquivo = new File(Main.getInstance().getDataFolder() + File.separator + folder);
		return Arquivo;
	}

	public static File getFile(String file, String folder) {
		File Arquivo = new File(Main.getInstance().getDataFolder() + File.separator + folder, file + ".yml");
		return Arquivo;
	}

	public static File getFile(String file) {
		File Arquivo = new File(Main.getInstance().getDataFolder() + File.separator + file + ".yml");
		return Arquivo;
	}

	public static FileConfiguration getConfiguration(File file) {
		FileConfiguration config = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
		return config;
	}

	public static void deleteFile(File file) {
		file.delete();
	}

}
