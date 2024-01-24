package braindustry.content;

import arc.graphics.Color;
import arc.math.Mathf;
import braindustry.maps.generators.OsorePlanetGenerator;
import braindustry.maps.generators.ShinrinPlanetGenerator;
import mindustry.content.Planets;
import mindustry.ctype.ContentList;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.SunMesh;
import mindustry.type.Planet;

public class ModPlanets implements ContentList {
    public static Planet zetsubo, osore, shinrin;

    public void load() {
        
        zetsubo = new Planet("zetsubo", Planets.sun, 2.4f, 3) {{
            localizedName = "Zetsubo";
            description = "Beatiful blue stars with high in Methane.";
            hasAtmosphere = true;
            meshLoader = () -> new SunMesh(
                    this, 4, 5, 0.3f, 1.0f, 1.2f, 1, 1.3f,
                    Color.valueOf("5E94FF"), 
                    Color.valueOf("214CDF"), 
                    Color.valueOf("2DA9DF"), 
                    Color.valueOf("9CB5FF"),
                    Color.valueOf("61729F"),
                    Color.valueOf("3BB1CA")
            );
            lightColor = Color.valueOf("214CDF");
            orbitRadius = 51.5f;
            bloom = true;
        }};
        
        osore = new Planet("osore", zetsubo, 1f, 3) {{
            localizedName = "Osore";
            description = "An unfavorable planet that survived a cataclysm and infection.";
            generator = new OsorePlanetGenerator();
            startSector = 25;
            atmosphereColor = Color.valueOf("8c3149");
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.4f;
            hasAtmosphere = true;
            meshLoader = () -> new HexMesh(this, 6);
            orbitRadius = 11.2f;
            tidalLock = true;
            orbitTime = Mathf.pow((2.0f + 14.0f + 0.66f), 1.5f) * 80;
            landCloudColor = Color.valueOf("8c3149");
            alwaysUnlocked = true;
        }};
        
        shinrin = new Planet("shinrin", zetsubo, 0.9f, 3) {{
            localizedName = "Shinrin";
            description = "A Companion to Osore,this is a favorable planet with developed flora and many forests, it was here that the enemy of sharded first landed";
            generator = new ShinrinPlanetGenerator();
            startSector = 42;
            atmosphereColor = Color.valueOf("36af54");
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.4f;
            hasAtmosphere = true;
            meshLoader = () -> new HexMesh(this, 6);
            orbitRadius = 9.4f;
            tidalLock = true;
            orbitTime = Mathf.pow((2.0f + 14.0f + 0.66f), 1.5f) * 55;
            landCloudColor = Color.valueOf("36af54");
            alwaysUnlocked = true;
        }};
    }
}
