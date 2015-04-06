package doanan.GamePieces.game;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import doanan.GamePieces.gameCards.Card;
import doanan.GamePieces.gameCards.Monster;
import doanan.GamePieces.gameCards.Weapon;
import doanan.GamePieces.gameComponentsCreate.ActionCreate;
import doanan.GamePieces.gameComponentsCreate.AmmunitionCreate;
import doanan.GamePieces.gameComponentsCreate.ItemCreate;
import doanan.GamePieces.gameComponentsCreate.MonsterCreate;
import doanan.GamePieces.gameComponentsCreate.WeaponCreate;
import doanan.GamePieces.gamePlayer.Deck;
import doanan.GamePieces.gamePlayer.Player;
import doanan.GamePieces.gamePlayer.PlayerHand;
import doanan.example.screens.R;

public class MainGameActivity extends Fragment {
	// Number of Images
	private final int imageNumber= 18;
	
	//Images
	ImageView 	image1,
				image2,
				image3,
				image4,
				image5,
				image6,
				image7,
				image8,
				image9,
				image10,
				image11,
				image12,
				image13,
				image14,
				image15,
                image16,
                image17,
                image18;

    View mainView;
		
	//Array of images to be shown
	ImageView[] images = new ImageView[imageNumber];
	
	// Image to use
	String imageFileName[] = new String[imageNumber];
	
	// Image Description
	String imageDescription[] = new String[imageNumber];
	
	// Image Title
	String imageTitle[] = new String[imageNumber];
	
	private Context context = getActivity();

	Player player = new Player();
	PlayerHand player1HAND = new PlayerHand();
	
	// ScrollView
	Button TurnEnd;
	LinearLayout inHorizontalScrollView1, inHorizontalScrollView2;

    // Check if card drawn
    private boolean drawn = false;

    // Used to set image cardType
    private int[] cardType = new int[imageNumber];

    public Card[] card = new Card[imageNumber];

    // Discarded
    ImageView Discard;

    // Checks if battle was won
    private boolean battleResult;

    // Card Creations
    WeaponCreate weapon = new WeaponCreate();
    AmmunitionCreate ammo = new AmmunitionCreate();
    ActionCreate action = new ActionCreate();
    ItemCreate item = new ItemCreate();

    MonsterCreate Mansion = new MonsterCreate();

    String characterScreenFragment;

    CharacterScreen characterScreen;

    int decorationsToWin = 10;

    public static MainGameActivity newInstance(String text) {

        MainGameActivity f = new MainGameActivity();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        mainView = inflater.inflate(R.layout.main_game, container, false);
        init();

        TextView tv = (TextView) mainView.findViewById(R.id.Discard);
        tv.setText(getArguments().getString("msg"));


        return mainView;
    }
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//
//        // Check to restore or create new activity
//        if(savedInstanceState != null){
//        // Restore value of members from saved state
//        }
//        else{
//            init();
//        }
//	}

    public void init(){
        /*
            Used to remove actionbar in this activity
        */
//        getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        getActivity().setContentView(R.layout.main_game);

//            gestureDetector = new GestureDetector(this,new GestureListener());

        // Cards Implemented
        characterScreenFragment = ((MainGameInterface)getActivity()).getCharacterFragment();
        characterScreen = (CharacterScreen)getActivity()
                .getSupportFragmentManager()
                .findFragmentByTag(characterScreenFragment);
        setPlayer(player);
        startingCards(player.DECK);
        declareImages();
        setImages(images,imageFileName,imageDescription,imageTitle,cardType,player.DECK);
        Deck();
        Mansion();
        viewDiscardDialog();

		    /*
		     * Scroll View
		    */
        // inHorizontalScrollView1 = (LinearLayout)findViewById(R.id.inhorizontalscrollview1);

        inHorizontalScrollView2 = (LinearLayout)mainView.findViewById(R.id.inhorizontalscrollview2);
        TurnEnd = (Button)mainView.findViewById(R.id.TurnEnd);
        turnEnd();
    }


    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    /**
     * Draws a 5 cards from the player's deck.
     */
	private void Draw(){
		player1HAND.draw(player.DECK);
	}
	
	/**
	 * Displays the 5 cards drawn in the horizontal view.
	 */
	private void displayDraw(LinearLayout layout, ArrayList<Card> playerDeck){
		for(int i = 0; i < 5;i++){
			displayDraws(layout, playerDeck,i);
		}
	}

    int cardIndex = 0;

    /**
     * Displays one card that is in the player's hand.
     *
     * @param layout The area to display cards that the player can use.
     * @param playerDeck The player's deck.
     * @param index Used to drawn a consecutive amount of cards.
     */
	private void displayDraws(final LinearLayout layout, ArrayList<Card> playerDeck,int index){
        final Card handCard = playerDeck.get(index);

        handCard.CARDINDEX = cardIndex;

        cardIndex++;

        final ImageView imageView = new ImageView(mainView.getContext());
        // Change ImageResource to the card that was played/drawn
//        imageView.setImageResource(R.drawable.test);
        imageAssets(imageView,handCard);
        imageView.setPadding(10,5,10,5);

		imageView.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				final Dialog dialog = new Dialog(mainView.getContext());
				dialog.setContentView(R.layout.bigimage);
				// Sets title to card
				String title;
//				title = player.DECK.getCardTitle();//imageTitle[iterator];
				title = handCard.getName();
				dialog.setTitle(title);

				//set the custom dialog components - text, image and button
				String imageDesc;
				imageDesc = handCard.getName();//imageDescription[iterator];
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText(imageDesc);
				ImageView image = (ImageView) dialog.findViewById(R.id.image);
				//Using image from Assets

                imageAssets(image,handCard);


				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				dialogButton.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						inHorizontalScrollView1 = (LinearLayout)mainView.findViewById(R.id.inhorizontalscrollview1);
						cardsUsed(inHorizontalScrollView1,handCard);


                        if (handCard.NAME.equals("Ominous Battle") && player.ACTION > 0){
                            useCard(handCard);

                            trashHandCard();
                            player.ACTION--;
                        }
                        else if(handCard.NAME.equals("Reload") && player.ACTION >0){
                            weaponInDiscard();
                        }
                        else if(handCard.NAME.equals("Umbrella Corporation") && player.ACTION >0){
                            useCard(handCard);

                            umbrellaCorporation();
                        }
                        else{
                            useCard(handCard);
                        }

						String text = player.NAME + " has " + player.AMMO + "  bullets.\n" +
									  "Player Hand: " + player1HAND.handSize();
						int duration = Toast.LENGTH_SHORT;
						Toast toast = Toast.makeText(mainView.getContext(), text, duration);
						toast.show();

						layout.removeView(imageView);

						dialog.dismiss();
						}
					});

				dialog.show();
				}
			});
		layout.addView(imageView);
	}
	
	/**
	 * Sets up the deck for drawing cards. 
	 * Five cards will me moved from the Deck to PlayerHand.
	 */
	private void Deck(){
		ImageView imageDeck = (ImageView) mainView.findViewById(R.id.Deck);
		imageDeck.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
                if(!drawn){
                    Draw();
                    displayDraw(inHorizontalScrollView2, player1HAND.playerHand);
                    drawn = true;
                    setDiscardHUD();
                    setDeckHUD();
                }
			}
		});
	}

    /**
     * Binds a card to an image from assets.
     *
     * @param image The image view to use a card.
     * @param handCard The card to be binded to the image.
     */
    public void imageAssets(ImageView image,Card handCard){
        AssetManager assetManager = getActivity().getAssets();
        InputStream istr;
        try{
            istr = assetManager.open("imgs/cards/"+ handCard.FILEPATH);
            Bitmap bitmap = BitmapFactory.decodeStream(istr);
            image.setImageBitmap(Bitmap.createScaledBitmap(bitmap,120,120,false));
            istr.close();
        }catch(IOException e){
            e.printStackTrace();
            image.setImageResource(R.drawable.test);
        }
    }
	
	/**
	 * If an ammo card is used call this function.
	 * <p>
	 * It allows an ammunition card to be used.
	 */

    /**
     * Checks the type of card and name of the card.
     * Then activates a specific function pertaining to the card type and name.
     *
     * @param card The card being used.
     */
	private void useCard(Card card){
		player1HAND.useCard(player, card);

        if(player.DRAWS != 0){
            for (int i=player1HAND.handSize()-player.DRAWS; player.DRAWS > 0; i++){
                displayDraws(inHorizontalScrollView2,player1HAND.playerHand,i);
                player.DRAWS--;
            }
        }

        setAmmoHUD();
        setDamageHUD();
        setGoldHUD();
        setDiscardHUD();
        setDeckHUD();
        setDamageHUD();
	}

    /**
     * Move a card from PlayerHand to Discard.
     */
    public void trashHandCard(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainView.getContext());
        builder.setTitle("Select a Card to Trash")
                .setItems(playerHandCardNames(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("TRASHHANDCARD","Index "+ which);
                        reorderCardIndex(player1HAND.playerHand,0);
                        trashCard(which);

                    }
                });
        builder.setCancelable(false);
        builder.create();
        builder.show();

    }


    /**
     * Removes a card from the player's hand.
     *
     * @param cardIndex The card to remove from the player's hand.
     */
    private void trashCard(int cardIndex){

        Card card;

        for (Card m: player1HAND.playerHand){
            Log.e("TrashedCard","Current card: " + m.NAME);
            Log.e("TrashedCard","Current cardIndex: " + m.CARDINDEX);
            if (m.CARDINDEX == cardIndex){
                card = m;

                Log.e("TrashedCard",card.NAME);

                player1HAND.trash(card);
                break;
            }
        }
        removeCardView(cardIndex);

        setAmmoHUD();
        setDamageHUD();
        setGoldHUD();
        setDiscardHUD();
        setDeckHUD();
        setDamageHUD();
    }


    /**
     * All cards in player hands have their CARD INDEX instance variable re-assigned new values.
     * Cards get get reassigned after a card was removed.
     *
     * @param cardPile Card pile being used.
     */
    public void reorderCardIndex(ArrayList<Card> cardPile, int weaponFlag){
        int i = 0;
        for(Card m: cardPile){
            // Works but is bad
            // Changes the instance of AMMOx10 etc. CardIndex
            if (weaponFlag == 1 && m.getClass().equals(Weapon.class)){
                m.CARDINDEX=i;
                i++;
            }
            else if(weaponFlag == 0){
                m.CARDINDEX = i;
                i++;
            }
        }
    }

    /**
     * Removes the imageView of the card being trashed.
     * imageView is removed from playerHand layout.
     *
     * @param card Card being removed.
     */
    public void removeCardView(int card){

        View v = inHorizontalScrollView2.getChildAt(card);
        v.setVisibility(View.GONE);
    }

    /**
     * Used to display all player card names in a dialog.
     *
     * @return Array of card names from player's hand.
     */
    public CharSequence[] playerHandCardNames(){
        List<String> cards = new ArrayList<>();
        for (Card m: player1HAND.playerHand){
            cards.add(m.NAME);
        }

        return cards.toArray(new CharSequence[cards.size()]);
    }

    public CharSequence[] discardPileCardNames(){
        List<String> cards = new ArrayList<String>();
        for (Card m: player1HAND.discardCards){
            cards.add(m.NAME);
        }

        return cards.toArray(new CharSequence[cards.size()]);
    }

    public void viewDiscardDialog(){
        Discard = (ImageView)mainView.findViewById(R.id.DiscardDeck);
        Discard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                discardDialog();
            }
        });
    }

    public void discardDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Discard Pile")
                .setItems(discardPileCardNames(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("DISCARD DECK","Index "+ which);
                    }
                });
        builder.create();
        builder.show();
    }

    public CharSequence[] discardedWeapons(){
        List<String> cards = new ArrayList<String>();
        for (Card m: player1HAND.discardCards){
            if(m.getClass().equals(Weapon.class)){
                cards.add(m.NAME);
                Log.e("TAG",""+m.getClass());
            }
        }

        return cards.toArray(new CharSequence[cards.size()]);
    }

    public void weaponInDiscard(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainView.getContext());
        builder.setTitle("WEAPONS IN DISCARD")
                .setItems(discardedWeapons(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Log.e(" WEAPONSinDISCARD","Index "+ which);
                        reload(which);

                    }
                });
        builder.create();
        builder.show();
    }

    public void reload(int cardIndex){
        reorderCardIndex(player1HAND.discardCards,1);


        Card card;

        for (Card m: player1HAND.discardCards){
            Log.e("RELOAD","Current card: " + m.NAME);
            Log.e("RELOAD","Current cardIndex: " + m.CARDINDEX);
            if (m.CARDINDEX == cardIndex){
                card = m;

                Log.e("RELOAD",card.NAME);

                player1HAND.discardToHand(card);
                displayDraws(inHorizontalScrollView2,player1HAND.playerHand,player1HAND.handSize()-1);

                break;
            }
        }
    }

    public void umbrellaCorporation(){
        // Move 1 card from your Hand to the top of your inventory
        // return selected card in player's hand
        // button to move it to top of deck

        AlertDialog.Builder builder = new AlertDialog.Builder(mainView.getContext());
        builder.setTitle("Select Card to Move To Top of Deck")
                .setItems(playerHandCardNames(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("UMBRELLA_CORPORATION","Index "+ which);
                        reorderCardIndex(player1HAND.playerHand,0);

                        umbrella(which);
                    }
                });
        builder.setCancelable(false);
        builder.create();
        builder.show();


    }

    public void umbrella(int cardIndex){
        Card card;

        for (Card m: player1HAND.playerHand){
            Log.e("UMBRELLA_CORP","Current card: " + m.NAME);
            Log.e("UMBRELLA_CORP","Current cardIndex: " + m.CARDINDEX);
            if (m.CARDINDEX == cardIndex){
                card = m;

                Log.e("TrashedCard",card.NAME);

                player1HAND.handToDeck(player.DECK,card);

//                player1HAND.trash(card);
                break;
            }
        }
        removeCardView(cardIndex);

        setAmmoHUD();
        setDamageHUD();
        setGoldHUD();
        setDiscardHUD();
        setDeckHUD();
        setDamageHUD();
    }



    /**
     * Sets up the Discard HUD.
     * Displays the amount of cards in Discard pile.
     */
    private void setDiscardHUD(){
        TextView discard = (TextView)mainView.findViewById(R.id.Discard);
        discard.setText("Discard: " + player1HAND.discardCards.size());

    }



    /**
     * Sets up the Deck HUD.
     * Displays teh amount of cards in the Deck pile.
     */
    private void setDeckHUD(){
        TextView deck = (TextView)mainView.findViewById(R.id.DeckSize);
        deck.setText("Deck: " + player.DECK.deckSize());
    }

    private void setAmmoHUD(){
        TextView ammo = (TextView)mainView.findViewById(R.id.AMMO);
        ammo.setText("Ammo: " + player.getPlayerAMMO());
    }

    /**
     * Sets up the Damage HUD.
     * Displays the amount of damage a player can inflict.
     */
    private void setDamageHUD(){
        TextView damage = (TextView)mainView.findViewById(R.id.DAMAGE);
        damage.setText("Damage: " + player.getPlayerDAMAGE());
        characterScreen.setCharacterHUD(player.HEALTH,player.DECORATIONS);
    }

    /**
     * Sets up the Gold HUD.
     * Displays the amount of gold a player has.
     */
    private void setGoldHUD(){
        TextView gold = (TextView)mainView.findViewById(R.id.GOLD);
        gold.setText("Gold: " + player.getPlayerGOLD());
    }


    /**
     * Cleans everything up and starts a new turn.
     * All counters will be set back to their default values.
     * All views will be emptied.
     */
    private void turnEnd(){
        //Move all player hand cards to discard pile
        //Move all cardsPlayed to discard pile
        //Reset all player counters (ammo, gold, buy, explore, action)
        TurnEnd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                //Check if player still has BUY, EXPLORE, and ACTION

                if (player1HAND != null){
                    if (inHorizontalScrollView2 != null){
                        inHorizontalScrollView2.removeAllViewsInLayout();
                    }
                }

                if (inHorizontalScrollView1 != null){
                    inHorizontalScrollView1.removeAllViewsInLayout();
                }


                player1HAND.discardEverything();
                player1HAND.removeEffects();

                player.AMMO = 0;
                player.GOLD = 0;
                player.BUY = 1;
                player.DAMAGE = 0;
                player.EXPLORE = 1;
                player.ACTION = 1;
                drawn = false;
                setAmmoHUD();
                setGoldHUD();
                setDamageHUD();
                setDiscardHUD();
                setDeckHUD();
                cardIndex = 0;

            }
        });

    }
	
	/**
	 * Change this to fight monsters later.
     * All monsters will be generated in MonsterCreate
     * Then there will be a pile of monsters generated.
     * Monsters are drawn randomly.
	 */
	private void Mansion(){
		ImageView imageDeck = (ImageView) mainView.findViewById(R.id.Mansion);
		imageDeck.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (player.EXPLORE > 0) {
                    Mansion.EXPLORE();
                    combat(Mansion.getCurrentMonster());


                    if (battleResult) {
                        // Get Rewards
                        player.DECORATIONS += Mansion.getDecoration();
                        setDamageHUD();
                    } else {
                        player.HEALTH -= Mansion.getDamage();
                        setDamageHUD();
                    }
                    showPopup(v, Mansion.getName(), Mansion.getHealth(), Mansion.getDamage(), Mansion.getDecoration());

                    setDiscardHUD();
                    setDeckHUD();
                    player.EXPLORE--;
                    checkWin();
                }
            }
        });
	}

    /**
     * Will compare a monster's damage/health to a player's damage.
     *
     * @param monster The monster being fought at the moment.
     */
    public void combat(Monster monster){
        //Check if ammo requirement meets weapons demands
        //Check if damage is >= monster health
        if (monster.getMonsterHasEffect()){
            monster.useEffectBefore(monster.NAME,player,player1HAND);
        }

        if (player.DAMAGE >= monster.HEALTH){
            battleResult = true;
        }
        else{
            battleResult = false;
            if (monster.getMonsterHasEffect()){
                monster.useEffectAfter(monster.NAME,Mansion,player1HAND);
            }
        }
    }

    public void showPopup(View anchorView,String monsterName,int monsterHealth,int monsterDamage,int monsterDecorations) {

        View popupView = getLayoutInflater(getArguments()).inflate(R.layout.combat, null);

        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);

        // Example: If you have a TextView inside `popup_layout.xml`
        TextView player_dmg = (TextView) popupView.findViewById(R.id.player_damage);
        TextView monster_dmg = (TextView) popupView.findViewById(R.id.monster_damage);

        TextView player_health = (TextView) popupView.findViewById(R.id.player_health);
        TextView monster_health = (TextView) popupView.findViewById(R.id.monster_health);

        TextView monster_decorations = (TextView) popupView.findViewById(R.id.monster_decorations);
        TextView battle_condition = (TextView) popupView.findViewById(R.id.battle_condition);

        TextView player_name = (TextView) popupView.findViewById(R.id.player_name);
        TextView monster_name = (TextView) popupView.findViewById(R.id.monster_name);

        player_dmg.setText("Player Damage: " + player.DAMAGE);
        monster_dmg.setText("Monster Damage: " + monsterDamage);

        player_health.setText("Player Health: " + player.HEALTH);
        monster_health.setText("Monster Health: " + monsterHealth);

        monster_decorations.setText("Rewards: " + monsterDecorations);

        player_name.setText(player.NAME);
        monster_name.setText(monsterName);

        if (battleResult){
            battle_condition.setText("Player Wins Combat");
        }
        else{
            battle_condition.setText("Monster Wins Combat");
        }


        // Initialize more widgets from `popup_layout.xml`


        // If the PopupWindow should be focusable
        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        int location[] = new int[2];

        // Get the View's(the one that was clicked in the Fragment) location
        anchorView.getLocationOnScreen(location);

        // Using location, the PopupWindow will be displayed right under anchorView
//        popupWindow.showAtLocation(anchorView, Gravity.NO_GRAVITY,
//                location[0], location[1] + anchorView.getHeight());

        popupWindow.showAtLocation(mainView, Gravity.CENTER, 0, 0);

    }



    public void checkWin(){
        if (player.DECORATIONS > decorationsToWin){
            gameEnd(true);
        }
        if (player.HEALTH < 0){
            gameEnd(false);
        }
    }

    public void gameEnd(boolean ending){
        // Show end game screen
        // Return to main menu
        if(ending){
            //do this because they won
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("YOU WIN")
                    .setTitle("WINNER");
            builder.setCancelable(false);
            builder.create();
            builder.show();
        }
        else{
            //do this because they lost
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("YOU LOSE")
                    .setTitle("LOSER");
            builder.setCancelable(false);
            builder.create();
            builder.show();
        }
    }



    public void setPlayer(Player player){
        doanan.GamePieces.gameCards.Character character= characterScreen.getCurrentCharacter();
        player.setPlayerName("Player1");
        player.setCharacterName(character.getNAME());
        player.setPlayerHealth(character.getHEALTH());
        player.setMaxHealth(character.getHEALTH());
        character = null;
        System.gc();
    }

    /**
     * Displays a card that was used here for viewing purposes.
     *
     * @param layout The layout where used cards will be displayed.
     * @param handCard The last card that was used.
     */
	private void cardsUsed(LinearLayout layout, final Card handCard){
		ImageView imageView = new ImageView(mainView.getContext());
		// Change ImageResource to the card that was played/drawn

        AssetManager assetManager = getActivity().getAssets();
        InputStream istr;
        try{
            istr = assetManager.open("imgs/cards/"+ handCard.FILEPATH);
            Bitmap bitmap = BitmapFactory.decodeStream(istr);
            imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmap,120,120,false));
            istr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        imageView.setPadding(10,5,10,5);
		
		imageView.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v) {

				final Dialog dialog = new Dialog(mainView.getContext());
				dialog.setContentView(R.layout.bigimage);
				
				// Sets title to card
				String title;
				title = handCard.getName();//imageTitle[iterator];
				dialog.setTitle(title);
				
				//set the custom dialog components - text, image and button
				String imageDesc;
				imageDesc = handCard.getName();//imageDescription[iterator];
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText(imageDesc);
				ImageView image = (ImageView) dialog.findViewById(R.id.image);

				try{
                    AssetManager assetManager = getActivity().getAssets();
                    InputStream istr;

                    istr = assetManager.open("imgs/cards/"+ handCard.FILEPATH);
                    Bitmap bitmap = BitmapFactory.decodeStream(istr);
                    image.setImageBitmap(Bitmap.createScaledBitmap(bitmap,120,120,false));
                    istr.close();
					}
				catch(IOException e){
					//handle
					image.setImageResource(R.drawable.test);
					return;
					}
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				dialogButton.setText("Cool Right");
				dialogButton.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						dialog.dismiss();
						}
					});
				
				dialog.show();
				}
			});
		layout.addView(imageView);
	}



    /**
     * Sets up starting cards for the player.
     * The cards include the following:
     * 7 Ammo x 10
     * 1 Pistol
     * 2 Knife
     *
     * @param deck The player's deck.
     */
    public void startingCards(Deck deck){
        for (int i=0; i < 7;i++){
            deck.add(ammo.ammo10);
        }
        deck.add(weapon.pistol);
        deck.add(weapon.knife);
        deck.add(weapon.knife);
        deck.shuffle();
    }

    /**
     * Sets up the imageViews to become a market.
     * All images will be clickable with text information and an image.
     */
	public void declareImages(){

		// Assigned imageViews to variables
		image1 = (ImageView) mainView.findViewById(R.id.imageView1);
		image2 = (ImageView) mainView.findViewById(R.id.imageView2);
		image3 = (ImageView) mainView.findViewById(R.id.imageView3);
		image4 = (ImageView) mainView.findViewById(R.id.imageView4);
		image5 = (ImageView) mainView.findViewById(R.id.imageView5);
		image6 = (ImageView) mainView.findViewById(R.id.imageView6);
		image7 = (ImageView) mainView.findViewById(R.id.imageView7);
		image8 = (ImageView) mainView.findViewById(R.id.imageView8);
		image9 = (ImageView) mainView.findViewById(R.id.imageView9);
		image10 = (ImageView) mainView.findViewById(R.id.imageView10);
		image11 = (ImageView) mainView.findViewById(R.id.imageView11);
		image12 = (ImageView) mainView.findViewById(R.id.imageView12);
		image13 = (ImageView) mainView.findViewById(R.id.imageView13);
		image14 = (ImageView) mainView.findViewById(R.id.imageView14);
		image15 = (ImageView) mainView.findViewById(R.id.imageView15);
        image16 = (ImageView) mainView.findViewById(R.id.imageView16);
        image17 = (ImageView) mainView.findViewById(R.id.imageView17);
        image18 = (ImageView) mainView.findViewById(R.id.imageView18);
		//Assign to array
		images[0] = image1;
		images[1] = image2;
		images[2] = image3;
		images[3] = image4;
		images[4] = image5;
		images[5] = image6;
		images[6] = image7;
		images[7] = image8;
		images[8] = image9;
		images[9] = image10;
		images[10] = image11;
		images[11] = image12;
		images[12] = image13;
		images[13] = image14;
		images[14] = image15;
        images[15] = image16;
        images[16] = image17;
        images[17] = image18;
		//Filename for each image
		imageFileName[0] = "pistol.jpg";
		imageFileName[1] = "burst_pistol.jpg";
		imageFileName[2] = "six_shooter.jpg";
		imageFileName[3] = "deadly_aim.jpg";
		imageFileName[4] = "reload.jpg";
		imageFileName[5] = "ammo_10.jpg";
		imageFileName[6] = "knife.jpg";
		imageFileName[7] = "machine_gun.jpg";
		imageFileName[8] = "shotgun.jpg";
		imageFileName[9] = "ominous_battle.jpg";
		imageFileName[10] = "mansion foyer.jpg";
		imageFileName[11] = "ammo_20.jpg";
		imageFileName[12] = "herb.jpg";
		imageFileName[13] = "first_aid.jpg";
		imageFileName[14] = "struggle_for_survival.jpg";
        imageFileName[15] = "merchant.jpg";
        imageFileName[16] = "umbrella_corporation.jpg";
        imageFileName[17] = "ammo_30.jpg";

        card[0] = weapon.pistol;
        card[1] = weapon.burstPistol;
        card[2] = weapon.magnum;
        card[3] = action.deadlyAim;
        card[4] = action.reload;
        card[5] = ammo.ammo10;
        card[6] = weapon.knife;
        card[7] = weapon.machineGun; // Machine Gun
        card[8] = weapon.shotgun; // Shotgun
        card[9] = action.ominousBattle;
        card[10] = action.mansionFoyer;
        card[11] = ammo.ammo20;
        card[12] = item.herb; // Herb
        card[13] = item.firstAid; // First Aid Spray
        card[14] = action.struggleForSurvival;
        card[15] = action.theMerchant;
        card[16] = action.umbrellaCorporation;
        card[17] = ammo.ammo30;
		// Description of image
		imageDescription[0] = "Cost: " + weapon.pistol.COST + "\n" +
                              "Ammo Requirement: " + weapon.pistol.AMMOREQUIREMENT + "\n" +
                              "Damage: " + weapon.pistol.DAMAGE + "\n" +
                              "Use this to shoot things.";

		imageDescription[1] = "Cost: " + weapon.burstPistol.COST + "\n" +
                              "Ammo Requirement: " + weapon.burstPistol.AMMOREQUIREMENT + "\n" +
                              "Damage: " + weapon.burstPistol.DAMAGE + "\n" +
                              "Use this to shoot things faster.";

		imageDescription[2] = "Cost: " + weapon.magnum.COST + "\n" +
                              "Ammo Requirement: " + weapon.magnum.AMMOREQUIREMENT + "\n" +
                              "Damage: " + weapon.magnum.DAMAGE + "\n" +
                              "Magnums are cool.";

		imageDescription[3] = "Cost: " + action.deadlyAim.COST + "\n" +
                              "Ammo Supplied: " + action.deadlyAim.AMMO + "\n" +
                              "All of your weapons being used get a +10 Dmg bonus this turn.";

		imageDescription[4] = "Cost: " + action.reload.COST + "\n" +
                              "Ammo Supplied: " + action.reload.AMMO + "\n" +
                              "Extra Actions: " + action.reload.EXTRA_ACTION + "\n" +
                              "Move a weapon from your discard pile to your Hand";

		imageDescription[5] = "Cost: " + ammo.ammo10.COST + "\n" +
                              "Ammo Supplied: " + ammo.ammo10.AMMO + "\n" +
                              "Gold Supploed: " + ammo.ammo10.GOLD + "\n" +
                              "Ammo to help you get started.";

		imageDescription[6] = "Cost: " + weapon.knife.COST + "\n" +
                              "Ammo Requirement: " + weapon.knife.AMMOREQUIREMENT + "\n" +
                              "Damage: " + weapon.knife.DAMAGE + "\n" +
                              "Knives are free but weak.";

		imageDescription[7] = "Cost: " + weapon.machineGun.COST + "\n" +
                              "Ammo Requirement: " + weapon.machineGun.AMMOREQUIREMENT + "\n" +
                              "Damage: " + weapon.machineGun.DAMAGE + "\n" +
                              "Machine guns have rapid fire.";

		imageDescription[8] = "Cost: " + weapon.shotgun.COST + "\n" +
                              "Ammo Requirement: " + weapon.shotgun.AMMOREQUIREMENT + "\n" +
                              "Damage: " + weapon.shotgun.DAMAGE + "\n" +
                              "Shotguns for close quarters.";

		imageDescription[9] = "Cost: " + action.ominousBattle.COST + "\n" +
                              "Gold Supplied: " + action.ominousBattle.GOLD + "\n" +
                              "Extra Cards: " + action.ominousBattle.EXTRA_CARDS + "\n" +
                              "Get more Gold and Draw more cards by using this. \n" +
                              "Also Trash 1 Card from your Hand." ;

		imageDescription[10] =  "Cost: " + action.mansionFoyer.COST + "\n" +
                                "Extra Draws: " + action.mansionFoyer.EXTRA_ACTION + "\n" +
                                "Draws two more cards.";

		imageDescription[11] = "Cost: " + ammo.ammo20.COST + "\n" +
                               "Ammo Supplied: " + ammo.ammo20.AMMO + "\n" +
                               "Gold Supploed: " + ammo.ammo20.GOLD + "\n" +
                               "Better ammo to help you grow";

		imageDescription[12] = "Cost: " + item.herb.COST + "\n" +
                               "Heals your character by 20 Health Points.";

		imageDescription[13] = "Cost: " + item.firstAid.COST + "\n" +
                               "Heals your character back to full health.";

		imageDescription[14] = "Cost: " + action.struggleForSurvival.COST + "\n" +
                               "Extra Actions: " + action.struggleForSurvival.EXTRA_ACTION + "\n" +
                               "Extra Explores: " + action.struggleForSurvival.EXTRA_EXPLORE + "\n" +
                               "Use this to play more action cards and explore the Mansion more.";

        imageDescription[15] = "Cost: " + action.theMerchant.COST + "\n" +
                               "Gold Supplied: " + action.theMerchant.GOLD + "\n" +
                               "Extra Cards Drawn: " + action.theMerchant.EXTRA_CARDS + "\n" +
                               "Extra Buys: " + action.theMerchant.EXTRA_BUY + "\n" +
                               "What are you buying?\n" +
                               "What are you selling?\n" +
                               "Use this to get gold, another draw, and buy more stuff...";

        imageDescription[16] = "Cost: " + action.umbrellaCorporation.COST + "\n" +
                               "Extra Cards Drawn: " + action.umbrellaCorporation.EXTRA_CARDS + "\n" +
                               "Extra Actions: " + action.umbrellaCorporation.EXTRA_ACTION + "\n" +
                               "Play this to move 1 card from your Hand to the top of your Deck.";

        imageDescription[17] = "Cost: " + ammo.ammo30.COST + "\n" +
                               "Ammo Supplied: " + ammo.ammo30.AMMO + "\n" +
                               "Gold Supplied: " + ammo.ammo30.GOLD + "\n" +
                               "Best ammo in the game.";

		// Title of image
		imageTitle[0] = weapon.pistol.NAME;
		imageTitle[1] = weapon.burstPistol.NAME;
		imageTitle[2] = weapon.magnum.NAME;
		imageTitle[3] = action.deadlyAim.NAME;
		imageTitle[4] = action.reload.NAME;
		imageTitle[5] = ammo.ammo10.NAME;
		imageTitle[6] = weapon.knife.NAME;
		imageTitle[7] = weapon.machineGun.NAME;
		imageTitle[8] = weapon.shotgun.NAME;
		imageTitle[9] = action.ominousBattle.NAME;
		imageTitle[10] = action.mansionFoyer.NAME;
		imageTitle[11] = ammo.ammo20.NAME;
		imageTitle[12] = item.herb.NAME;
		imageTitle[13] = item.firstAid.NAME;
		imageTitle[14] = action.struggleForSurvival.NAME;
        imageTitle[15] = action.theMerchant.NAME;
        imageTitle[16] = action.umbrellaCorporation.NAME;
        imageTitle[17] = ammo.ammo30.NAME;
        // Card Type
        /*
        0 = Weapon
        1 = Action
        2 = Ammunition
        3 = Item
         */
        cardType[0] = 0;
        cardType[1] = 0;
        cardType[2] = 0;
        cardType[3] = 1;
        cardType[4] = 1;
        cardType[5] = 2;
        cardType[6] = 0;
        cardType[7] = 0;
        cardType[8] = 0;
        cardType[9] = 1;
        cardType[10] = 1;
        cardType[11] = 2;
        cardType[12] = 3;
        cardType[13] = 3;
        cardType[14] = 1;
        cardType[15] = 1;
        cardType[16] = 1;
        cardType[17] = 2;

	}


    /**
     * TODO
     * Change parameters to take in Card Array.
     * Will access member variables of each card.
     *
     * Makes all images in the market clickable.
     * All clickable images will allow players to purchase cards in the market.
     * Once purchased, the card will be added to the player's deck.
     *
     * @param image ImageView array of image Views.
     * @param imageFileName String array of image filenames.
     * @param imageDescription String array of description of images.
     * @param imageTitle String array of image titles.
     * @param cardType Array of all card types.
     * @param deck The deck of the player
     */
	public void setImages(ImageView[] image,String[] imageFileName, String[] imageDescription, String[] imageTitle, int[] cardType, Deck deck){

		int iterator = 0;


		for(ImageView img:image){


            AssetManager assetManager = getActivity().getAssets();
            InputStream istr;
            try{
                istr = assetManager.open("imgs/cards/"+ imageFileName[iterator]);
                Bitmap bitmap = BitmapFactory.decodeStream(istr);
                img.setImageBitmap(Bitmap.createScaledBitmap(bitmap,120,120,false));
                istr.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            img.setPadding(10, 5, 10, 5);

			img.setOnClickListener(new myOnClickListener(context,imageFileName,imageDescription,imageTitle,cardType,iterator,deck){
				public void onClick(View v){
					final Dialog dialog = new Dialog(mainView.getContext());
					dialog.setContentView(R.layout.bigimage);


					// Sets title to card
					final String title;
					title = imageTitle[iterator];
					dialog.setTitle(title);

					//set the custom dialog components - text, image and button
					String imageDesc;
					imageDesc = imageDescription[iterator];
					TextView text = (TextView) dialog.findViewById(R.id.text);
					text.setText(imageDesc);
					ImageView image = (ImageView) dialog.findViewById(R.id.image);
					//Using image from Assets

					String imageName;
					imageName = imageFileName[iterator];

					final String cardName = imageName;

					try{
                        AssetManager assetManager = getActivity().getAssets();
                        InputStream istr;

                            istr = assetManager.open("imgs/cards/"+ imageName);
                            Bitmap bitmap = BitmapFactory.decodeStream(istr);
                            image.setImageBitmap(Bitmap.createScaledBitmap(bitmap,120,120,false));
                            istr.close();

                        image.setPadding(10,5,10,5);
					}
					catch(IOException e){
						//handle
						image.setImageResource(R.drawable.ic_launcher);
						return;
					}

					Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
					//if button is clicked, close the custom dialog

                    final int type = cardType[iterator];

					dialogButton.setOnClickListener(new cardAddOnClickListener(deck,type){
						public void onClick(View v){
                             /*
                             0 = Weapon
                             1 = Action
                             2 = Ammunition
                             3 = Item
                             */
                            switch (type){
                                case 0:
                                    addWeapon(deck, title);
                                    break;
                                case 1:
                                    addAction(deck, title);
                                    break;
                                case 2:
                                    addAmmunition(deck, title);
                                    break;
                                case 3:
                                    addItem(deck, title);
                                    break;
                            }
							dialog.dismiss();
						}
					});

					dialog.show();
				}
			});
			iterator++;
		}
	}

    /**
     * Adds a weapon card to the player's deck.
     *
     * @param deck Player's deck.
     * @param cardName The card's name that will be added to the player's deck.
     */
    public void addWeapon(Deck deck, String cardName){
        WeaponCreate weapon = new WeaponCreate();

        if (cardName.equals(weapon.pistol.NAME) && player.GOLD >= weapon.pistol.COST){
            deck.add(weapon.pistol);
        }
        else if (cardName.equals(weapon.knife.NAME)&& player.GOLD >= weapon.knife.COST){
            deck.add(weapon.knife);
        }
        else if(cardName.equals(weapon.burstPistol.NAME) && player.GOLD >= weapon.burstPistol.COST){
            deck.add(weapon.burstPistol);
        }
        else if(cardName.equals(weapon.magnum.NAME)&& player.GOLD >= weapon.magnum.COST){
            deck.add(weapon.magnum);
        }
        else if (cardName.equals(weapon.machineGun.NAME) && player.GOLD >= weapon.machineGun.COST){
            deck.add(weapon.machineGun);
        }
        else if (cardName.equals(weapon.shotgun.NAME) && player.GOLD >= weapon.shotgun.COST){
            deck.add(weapon.shotgun);
        }

    }
    public void addAction(Deck deck, String cardName){
        ActionCreate action = new ActionCreate();

        if (cardName.equals(action.deadlyAim.NAME) && player.GOLD >= action.deadlyAim.COST){
            deck.add(action.deadlyAim);
        }
        else if(cardName.equals(action.reload.NAME) && player.GOLD >= action.reload.COST){
            deck.add(action.reload);
        }
        else if(cardName.equals(action.ominousBattle.NAME) && player.GOLD >= action.ominousBattle.COST){
            deck.add(action.ominousBattle);
        }
        else if(cardName.equals(action.mansionFoyer.NAME) && player.GOLD >= action.mansionFoyer.COST){
            deck.add(action.mansionFoyer);
        }
        else if(cardName.equals(action.struggleForSurvival.NAME) && player.GOLD >= action.struggleForSurvival.COST){
            deck.add(action.struggleForSurvival);
        }
        else if(cardName.equals(action.theMerchant.NAME) && player.GOLD >= action.theMerchant.COST){
            deck.add(action.theMerchant);
        }
        else if(cardName.equals(action.umbrellaCorporation.NAME) && player.GOLD >= action.umbrellaCorporation.COST){
            deck.add(action.umbrellaCorporation);
        }


    }
    public void addAmmunition(Deck deck, String cardName){
        AmmunitionCreate ammo = new AmmunitionCreate();

        if (cardName.equals(ammo.ammo10.NAME) && player.GOLD >= ammo.ammo10.COST){
            deck.add(ammo.ammo10);
        }
        else if (cardName.equals(ammo.ammo20.NAME)  && player.GOLD >= ammo.ammo20.COST){
            deck.add(ammo.ammo20);
        }

        else if(cardName.equals(ammo.ammo30.NAME)  && player.GOLD >= ammo.ammo30.COST){
            deck.add(ammo.ammo30);
        }
    }
    public void addItem(Deck deck, String cardName){
        ItemCreate item = new ItemCreate();

        if (cardName.equals(item.herb.NAME)  && player.GOLD >= item.herb.COST){
            deck.add(item.herb);
        }
        else if (cardName.equals(item.firstAid.NAME)  && player.GOLD >= item.firstAid.COST){
            deck.add(item.firstAid);
        }
    }

}
