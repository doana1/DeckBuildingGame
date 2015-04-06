package doanan.GamePieces.gameCards;

import doanan.GamePieces.gameComponentsCreate.MonsterCreate;
import doanan.GamePieces.gamePlayer.Player;
import doanan.GamePieces.gamePlayer.PlayerHand;

public class Monster {
	
	/*
	 * Monster attributes
	 * Card Type
	 * Monster Name (From Card Class)
	 * Health
	 * Effect
	 * Damage
	 * Decoration Reward
	 */

	public String NAME;
    public int HEALTH, DAMAGE, DECORATIONS;
	public boolean EFFECT;

//	public Monster(String name, int cost, int health, int ammo,int ammorequirement, int damage, boolean effect, int reward, int cardIndex, int gold) {
//		super(name, cost, ammo,ammorequirement, damage,cardIndex, gold, "royalty.png");
////		this.NAME = name;
////		this.COST = cost;
//		this.HEALTH = health;
//		this.DAMAGE = damage;
//		this.REWARD = reward;
//		this.EFFECT = effect;
//	}

    public Monster(String name, int health, int damage, int decorations, boolean effect){
        this.NAME = name;
        this.HEALTH = health;
        this.DAMAGE = damage;
        this.DECORATIONS = decorations;
        this.EFFECT = effect;
    }

    public void useEffectBefore(String monsterName,Player player,PlayerHand playerhand){
        switch (monsterName){
            case "Gatling Gun Majini": dmgIncrease(playerhand);
                break;
            case "Nemesis T-Type": immediateDamage(player);
                break;
        }
    }

    public void useEffectAfter(String monsterName,MonsterCreate mansion,PlayerHand playerhand){
        switch (monsterName){
            case "Uroboros Aheri": returnToMansion(mansion);
                break;
            case "Hunter": trash2Random(playerhand);
                break;
        }
    }

    public int dmgIncrease(PlayerHand playerhand){
        int ammo10 = 0;
        for (Card m: playerhand.playerHand){
            if (m.NAME == "Ammunitionx10"){
                ammo10++;
            }
        }
        for (Card m: playerhand.usedCards){
            if (m.NAME == "Ammunitionx10"){
                ammo10++;
            }
        }
        return (ammo10 & 5);
    }



    public void immediateDamage(Player player){
        player.HEALTH -= 20;
    }

    public void trash2Random(PlayerHand playerHand){
        playerHand.shuffleDiscard();
        for (int i= 0; i < 2; i++){
            playerHand.discardCards.remove(playerHand.discardCards.size()-1);
        }
    }

    public void returnToMansion(MonsterCreate mansion){
        mansion.returnToMansion();
    }

    public boolean getMonsterHasEffect(){
        return EFFECT;
    }
}
