package com.jasonfc.blogger;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jasonfc.Display;

public class BloggerDisplay implements Display {

	@Override
	public String getDisplayString(String responseFromInternet) {
		StringBuilder builder = new StringBuilder();
		Gson gson = new Gson();
		JsonElement json = new JsonParser().parse(responseFromInternet);
		JsonObject jsonObject = json.getAsJsonObject();
		BlogList objs = gson.fromJson(jsonObject, BlogList.class);
		builder.append(objs.getKind());
		builder.append("\n");
		List<Items> itemsList = objs.getItems();
		for (Items item : itemsList) {
			builder.append(item.getAuthor().getDisplayName());
			builder.append(" --> ");
			builder.append("\n");
			builder.append("  ");
			builder.append(item.getTitle());
			builder.append("\n");
		}
		return builder.toString();
	}

}
