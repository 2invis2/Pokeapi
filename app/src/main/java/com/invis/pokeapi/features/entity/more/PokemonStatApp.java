package com.invis.pokeapi.features.entity.more;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PokemonStatApp implements Parcelable {
    private String name;
    private int value;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.value);
    }

    protected PokemonStatApp(Parcel in) {
        this.name = in.readString();
        this.value = in.readInt();
    }

    public static final Parcelable.Creator<PokemonStatApp> CREATOR = new Parcelable.Creator<PokemonStatApp>() {
        @Override
        public PokemonStatApp createFromParcel(Parcel source) {
            return new PokemonStatApp(source);
        }

        @Override
        public PokemonStatApp[] newArray(int size) {
            return new PokemonStatApp[size];
        }
    };
}