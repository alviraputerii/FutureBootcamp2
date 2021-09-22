package org.example.app.data;

import lombok.Data;

@Data
public class YugiOhCardsData {
 private String cardName;
 private String attribute;
 private String rank;
 private String monsterType;
 private String cardType;
 private String atk;
 private String def;
 private String cardEffects;
 private String pendulumEffects;
 private Boolean flagFailed;
}