package com.invis.pokeapi.features.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.invis.pokeapi.features.entity.more.PokemonStatApp;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pokemon implements Parcelable {
    private int order;
    private String name;
    private int height;
    private int weight;
    private List<String> types;
    private List<PokemonStatApp> stats;

    public int indexStat(String statName){
        for (int i = 0; i < stats.size(); i++) {
            if (stats.get(i).getName().equals(statName)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.order);
        dest.writeString(this.name);
        dest.writeInt(this.height);
        dest.writeInt(this.weight);
        dest.writeStringList(this.types);
        dest.writeList(this.stats);
    }

    protected Pokemon(Parcel in) {
        this.order = in.readInt();
        this.name = in.readString();
        this.height = in.readInt();
        this.weight = in.readInt();
        this.types = in.createStringArrayList();
        this.stats = new ArrayList<PokemonStatApp>();
        in.readList(this.stats, PokemonStatApp.class.getClassLoader());
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel source) {
            return new Pokemon(source);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };
}
