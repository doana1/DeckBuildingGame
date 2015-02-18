package com.doanan.game;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.doanan.gameCards.Card;
import com.doanan.gameComponentsCreate.ActionCreate;
import com.doanan.gameComponentsCreate.AmmunitionCreate;
import com.doanan.gameComponentsCreate.CharacterCreate;
import com.doanan.gameComponentsCreate.ItemCreate;
import com.doanan.gameComponentsCreate.WeaponCreate;
import com.doanan.gamePlayer.Deck;
import com.doanan.gamePlayer.Player;
import com.doanan.gamePlayer.PlayerHand;
import com.example.firstgame.R;

import java.io.IOException;
import java.io.InputStream;

public class MainGameActivity extends Activity {
	//Card Types
	String Character, Ammunition, Weapon, Infected, Token, Item, Action;
	
	//Card Attributes
	String Name, Cost, Health, Effect, Gold, Ammo, Damage, Decorations;
	
	//Turns
	public enum Turn{
		ACTION, BUY, EXPLORE
	}
	
	// Number of Images
	private final int imageNumber= 15; 
	
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
				image15;
		
		
	//Array of images to be shown
	ImageView[] images = new ImageView[imageNumber];
	
	// Image to use
	String imageFileName[] = new String[imageNumber];
	
	// Image Description
	String imageDescription[] = new String[imageNumber];
	
	// Image Title
	String imageTitle[] = new String[imageNumber];
	
	private Context context = this;
	
	Deck deck1 = new Deck();
	Player player = new Player("JIM", "REBECCA", 120, 0, 0, 0, 0, 0);
	PlayerHand player1HAND = new PlayerHand();
	
	// ScrollView
	Button addinHorizontalScrollView1, TurnEnd;
	LinearLayout inHorizontalScrollView1, inHorizontalScrollView2, inScrollView1;

    // Check if card drawn
    private boolean drawn = false;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        // Check to restore or create new activity
        if(savedInstanceState != null){
            // Restore value of members from saved state

        }
        else{
            /*
             Used to remove actionbar in this activity
             */
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.main_game);

            // textView2.setText(chris.NAME);
            // textView2.setText(Integer.toString(chris.DECORATIONS));


            // Cards Implemented
            declareImages();
            setImages(images,imageFileName,imageDescription,imageTitle,deck1);
            Deck();
            Mansion();

		    /*
		     * Scroll View
		    */
            // inHorizontalScrollView1 = (LinearLayout)findViewById(R.id.inhorizontalscrollview1);

            inHorizontalScrollView2 = (LinearLayout)findViewById(R.id.inhorizontalscrollview2);
            TurnEnd = (Button)findViewById(R.id.TurnEnd);
            turnEnd();
        }




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
	 * Draws cards from the player's deck.
	 */
	private void Draw(){
		player1HAND.draw(deck1);
	}
	
	/**
	 * Displays the cards drawn in the horizontal view.
	 */
	private void displayDraw(LinearLayout layout){
		for(int i = 0; i < 5;i++){
			displayDraws(layout, i);
		}
	}
	
	/*TODO
	 * Display cards by drawing them
	 * Cards function when used properly
	 * Cards move to Cards played area once played
	 * Card that moves will vanish from this area.
	 */
	private void displayDraws(final LinearLayout layout, int index){
		final Card handCard = player1HAND.playerHand.get(index);
		final ImageView imageView = new ImageView(this);
		// Change ImageResource to the card that was played/drawn
		imageView.setImageResource(R.drawable.test);
		
		imageView.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v) {
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.bigimage);
				
				// Sets title to card
				String title;
//				title = deck1.getCardTitle();//imageTitle[iterator];
				title = handCard.getName();
				dialog.setTitle(title);
				
				//set the custom dialog components - text, image and button
				String imageDesc;
				imageDesc = handCard.getName();//imageDescription[iterator];
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText(imageDesc);
				ImageView image = (ImageView) dialog.findViewById(R.id.image);
				//Using image from Assets
				String imageName;
				imageName = "ace_of_hearts.jpg";//imageFileName[iterator];
				
				try{
					//get input stream
					InputStream ims = getAssets().open("imgs/cards/" + imageName);
					//load image as Drawable
					Drawable d = Drawable.createFromStream(ims, null);
					//set image to ImageView
					image.setImageDrawable(d);
					}
				catch(IOException e){
					//handle
					image.setImageResource(R.drawable.test);
					return;
					}
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				dialogButton.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						//TODO
						//Card in Player Hand will be used
						//The card will then be moved to CardUsed
						//Then it will appear in that horizontal View
						
						//START TESTING OF MOVING CARDS TO CARDS PLAYED
						
						inHorizontalScrollView1 = (LinearLayout)findViewById(R.id.inhorizontalscrollview1);
						cardsUsed(inHorizontalScrollView1,handCard);
						//END TESTING OF MOVING CARDS TO CARDS PLAYED

						useCard(handCard);
//						
						String text = player.NAME + " has " + player.AMMO + "  bullets.\n" +
									  "Player Hand: " + player1HAND.handSize();
						int duration = Toast.LENGTH_SHORT;
						Toast toast = Toast.makeText(context, text, duration);
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
		ImageView imageDeck = (ImageView) findViewById(R.id.Deck);
		imageDeck.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
                if(drawn){

                }
                else{
                    Draw();
                    displayDraw(inHorizontalScrollView2);
                    drawn = true;
                }
			}
		});
	}
	
	/**
	 * If an ammo card is used call this function.
	 * <p>
	 * It allows an ammunition card to be used.
	 */

	private void useCard(Card card){
		player1HAND.useCard(player, card);

        setAmmoHUD();
	}

    private void setAmmoHUD(){
        TextView ammo = (TextView)findViewById(R.id.AMMO);
        ammo.setText("Ammo: " + player.getPlayerAMMO());
    }


    /**
    Cleans everything up and starts a new turn
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
                    player1HAND.discardAll(player1HAND.playerHand);
                    player1HAND.discardAll(player1HAND.usedCards);
                    if (inHorizontalScrollView2 != null){
                        inHorizontalScrollView2.removeAllViewsInLayout();
                    }
                    if (inHorizontalScrollView1 != null){
                        inHorizontalScrollView1.removeAllViewsInLayout();
                    }
                }
                player.AMMO = 0;
                player.GOLD = 0;
                player.BUY = 0;
                player.EXPLORE = 0;
                player.ACTION = 0;
                drawn = false;
                setAmmoHUD();
            }
        });

    }
	
	/**
	 * TODO
	 * Change this to fight monsters later.
	 * Currently used to add Cards to the Deck quickly.
	 */
	private void Mansion(){
		ImageView imageDeck = (ImageView) findViewById(R.id.Mansion);
		imageDeck.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				final AmmunitionCreate ammo = new AmmunitionCreate();
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				deck1.add(ammo.ammo10);
				deck1.add(ammo.ammo20);
				deck1.add(ammo.ammo30);
				String text = "Deck has " + deck1.deckSize() + " cards.\n" +
							  "Player has " + player1HAND.handSize() + " cards in their hand.";
				int duration = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
		});
	}
	

	/*
	 * Adds an image to the horizontal Scroll View
	 * Player Hand will be displayed Here
	 * If Card is used
	 * That Card will be moved into the Card Played Horizontal Viewed
	 */
	private void cardsUsed(LinearLayout layout, final Card handCard){
		ImageView imageView = new ImageView(this);
		// Change ImageResource to the card that was played/drawn
		imageView.setImageResource(R.drawable.test);
		
		imageView.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v) {
				// TODO 
				final Dialog dialog = new Dialog(context);
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
				//Using image from Assets
				String imageName;
				imageName = "ace_of_hearts.jpg";//imageFileName[iterator];
				
				try{
					//get input stream
					InputStream ims = getAssets().open("imgs/cards/" + imageName);
					//load image as Drawable
					Drawable d = Drawable.createFromStream(ims, null);
					//set image to ImageView
					image.setImageDrawable(d);
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
						//TODO
						//Card in Player Hand will be used
						//The card will then be moved to CardUsed
						//Then it will appear in that horizontal View
						
						//START TESTING OF MOVING CARDS TO CARDS PLAYED
						
						//END TESTING OF MOVING CARDS TO CARDS PLAYED
						
						//TESTING TO USE AMMO CARD
						dialog.dismiss();
						}
					});
				
				dialog.show();
				}
			});
		layout.addView(imageView);
	}
	
	/*
	 * Function to add onClick event to view cards in different piles
	 * Parameters should include information to indicate which card was played or drawn
	 */
	public void onClick(Deck deck){
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.bigimage);
		
		
		// Sets title to card
		String title;
		title = deck.getCardTitle();//imageTitle[iterator];
		dialog.setTitle(title);
		
		//set the custom dialog components - text, image and button
		String imageDesc;
		imageDesc = deck.getCardTitle();//imageDescription[iterator];
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText(imageDesc);
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		//Using image from Assets
		
		String imageName;
		imageName = "What";//imageFileName[iterator];
		
		try{
			//get input stream
			InputStream ims = getAssets().open("imgs/cards/" + imageName);
			//load image as Drawable
			Drawable d = Drawable.createFromStream(ims, null);
			//set image to ImageView
			image.setImageDrawable(d);
			image.setImageResource(R.drawable.test);
		}
		catch(IOException e){
			//handle
			image.setImageResource(R.drawable.test);
			return;
		}
		
		dialog.show();
	}

    public void combat(){
        //Check if ammo requirement meets weapons demands
        //Check if damage is >= monster health
    }
	
	public void declareImages(){
		// Declare Characters
		CharacterCreate char1 = new CharacterCreate();
		// Declare Ammo
		AmmunitionCreate ammo1 = new AmmunitionCreate();
        WeaponCreate weapon1 = new WeaponCreate();
		
		// Assigned imageviews to variables
		image1 = (ImageView) findViewById(R.id.imageView1);
		image2 = (ImageView) findViewById(R.id.imageView2);
		image3 = (ImageView) findViewById(R.id.imageView3);
		image4 = (ImageView) findViewById(R.id.imageView4);
		image5 = (ImageView) findViewById(R.id.imageView5);
		image6 = (ImageView) findViewById(R.id.imageView6);
		image7 = (ImageView) findViewById(R.id.imageView7);
		image8 = (ImageView) findViewById(R.id.imageView8);
		image9 = (ImageView) findViewById(R.id.imageView9);
		image10 = (ImageView) findViewById(R.id.imageView10);
		image11 = (ImageView) findViewById(R.id.imageView11);
		image12 = (ImageView) findViewById(R.id.imageView12);
		image13 = (ImageView) findViewById(R.id.imageView13);
		image14 = (ImageView) findViewById(R.id.imageView14);
		image15 = (ImageView) findViewById(R.id.imageView15);
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
		//Filename for each image
		imageFileName[0] = "ace_of_hearts.jpg";
		imageFileName[1] = "ace_of_spades.jpg";
		imageFileName[2] = "ace_of_diamonds.jpg";
		imageFileName[3] = "ace_of_clubs.jpg";
		imageFileName[4] = "king_of_hearts2.jpg";
		imageFileName[5] = "king_of_spades2.jpg";
		imageFileName[6] = "king_of_diamonds2.jpg";
		imageFileName[7] = "king_of_clubs2.jpg";
		imageFileName[8] = "queen_of_hearts2.jpg";
		imageFileName[9] = "queen_of_spades2.jpg";
		imageFileName[10] = "queen_of_diamonds2.jpg";
		imageFileName[11] = "queen_of_clubs2.jpg";
		imageFileName[12] = "red_joker.jpg";
		imageFileName[13] = "black_joker.jpg";
		imageFileName[14] = "royalty.png";
		// Description of image
		imageDescription[0] = "ACE OF HEARTS";
		imageDescription[1] = "ACE OF SPADES";
		imageDescription[2] = "ACE OF DIAMONDS";
		imageDescription[3] = "ACE OF CLUBS";
		imageDescription[4] = "A talented girl, Rebecca graduated college at the young age of 18.[7] Her expertise in chemistry and medicine earned her a position in the Special Tactics And Rescue Service, a Raccoon City Police Department branch handling specialist cases. She was assigned as Rear Security (RS) and Medic for the Bravo team.[7] She became the unit's youngest and most inexperienced member, which made her quite nervous around her teammates.[7] Because of this, she was eager to please and has been known to take on any task assigned to her without hesitation.";
		imageDescription[5] = "KING OF SPADES";
		imageDescription[6] = "KING OF DIAMONDS";
		imageDescription[7] = "KING OF CLUBS";
		imageDescription[8] = "QUEEN OF HEARTS";
		imageDescription[9] = "Gives 10 ammo";
		imageDescription[10] = "QUEEN OF DIAMONDS";
		imageDescription[11] = "QUEEN OF CLUBS";
		imageDescription[12] = "RED JOKER";
		imageDescription[13] = "BLACK JOKER";
		imageDescription[14] = "ROYALTY";
		// Title of image
		imageTitle[0] = weapon1.pistol.NAME;
		imageTitle[1] = "ACE OF SPADES";
		imageTitle[2] = "ACE OF DIAMONDS";
		imageTitle[3] = "ACE OF CLUBS";
		imageTitle[4] = char1.Rebecca.NAME;
		imageTitle[5] = "KING OF SPADES";
		imageTitle[6] = "KING OF DIAMONDS";
		imageTitle[7] = "KING OF CLUBS";
		imageTitle[8] = "QUEEN OF HEARTS";
		imageTitle[9] = ammo1.ammo10.NAME;
		imageTitle[10] = "QUEEN OF DIAMONDS";
		imageTitle[11] = "QUEEN OF CLUBS";
		imageTitle[12] = "RED JOKER";
		imageTitle[13] = "BLACK JOKER";
		imageTitle[14] = "ROYALTY";
	}
	
	public void setImages(ImageView[] image,String[] imageFileName, String[] imageDescription, String[] imageTitle, Deck deck){

		

		int iterator = 0;
		final AmmunitionCreate ammo = new AmmunitionCreate();
		final ActionCreate action = new ActionCreate();
		final ItemCreate item = new ItemCreate();
		final WeaponCreate weapon = new WeaponCreate();
		//TODO
		//Remove the adding cards to deck
		//It is being used to test drawing cards to Player Hand
		//and moving cards to Used Cards
		//then Discarding them

		for(ImageView img:image){
			img.setOnClickListener(new myOnClickListener(context,imageFileName,imageDescription,imageTitle,iterator,deck){
				public void onClick(View v){
					final Dialog dialog = new Dialog(context);
					dialog.setContentView(R.layout.bigimage);
					
					
					// Sets title to card
					String title;
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
						/*
						 * TODO
						 * Still deciding if I want to store images in the 
						 * assets folder
						 */
						//get input stream
						InputStream ims = getAssets().open("imgs/cards/" + imageName);
						//load image as Drawable
						Drawable d = Drawable.createFromStream(ims, null);
						//set image to ImageView
						image.setImageDrawable(d);
					}
					catch(IOException e){
						//handle
						image.setImageResource(R.drawable.ic_launcher);
						return;
					}
					
					Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
					//if button is clicked, close the custom dialog
					dialogButton.setOnClickListener(new cardAddOnClickListener(deck){
						public void onClick(View v){
							Context context = getApplicationContext();
							CharSequence text = "Card Bought~~~";
							int duration = Toast.LENGTH_SHORT;

							String itemCard = "(.*)king(.*)";
							String ammoCard = "(.*)queen(.*)";
							String actionCard = "(.*)action(.*)";
							String weaponCard = "(.*)weapon(.*)";
							
							if(cardName.matches(itemCard)){
								/*
								 * TODO
								 * Call Functions Here
								 * Functions determine which card to add to the Deck
								 */
								deck.add(item.item1);
								text = deck.itemC();
								Toast toast = Toast.makeText(context, text, duration);
								toast.show();
								/*
								 * Separate function to assign what to do with each card
								 */
							}
							
							if(cardName.matches(ammoCard)){
								deck.add(ammo.ammo10);
								text = deck.ammoC();
								Toast toast = Toast.makeText(context, text, duration);
								toast.show();
								/*
								 * Separate function to assign what to do with each card
								 */
							}
							
							if(cardName.matches(actionCard)){
								deck.add(action.action1);
								text = "action Card";
								Toast toast = Toast.makeText(context, text, duration);
								toast.show();
								/*
								 * Separate function to assign what to do with each card
								 */
							}
							
							if(cardName.matches(weaponCard)){
								deck.add(weapon.pistol);
								text = "Testing";
								Toast toast = Toast.makeText(context, text, duration);
								toast.show();
								/*
								 * Separate function to assign what to do with each card
								 */
							}
								

							
							/*
							 * Check which card to add based on image
							 * Card Types that can be bought
							 * (Action, Ammunition, Item, Weapon)
							 */
							dialog.dismiss();
						}
					});
					
					dialog.show();
				}
			});
			iterator++;
		}
	}

}
