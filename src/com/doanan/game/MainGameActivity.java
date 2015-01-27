package com.doanan.game;

import java.io.IOException;
import java.io.InputStream;

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
import android.widget.TextView;

import com.doanan.gameCards.Character;
import com.doanan.gameComponentsCreate.AmmunitionCreate;
import com.doanan.gameComponentsCreate.CharacterCreate;
import com.example.firstgame.R;

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
	
	/*
	 * Used to test Cards
	 */
	String name = "BOB";
	String characterName = "Chris";
	int cost = 500;
	int health = 20;
	int decorations = 2;
	int level = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/*
		 * Used to remove actionbar in this activity
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.main_game);
		
		
		// Implement the Cards
		Character chris = new Character(characterName,cost,health,decorations,level);
		
		
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		textView2.setText(chris.NAME);
		textView2.setText(Integer.toString(chris.DECORATIONS));
		
		
		// Cards Implemented
		
		
		declareImages();
		setImages(images,imageFileName,imageDescription,imageTitle);
	}
	
	public void declareImages(){
		// Declare Characters
		CharacterCreate char1 = new CharacterCreate();
		// Declare Ammo
		AmmunitionCreate ammo1 = new AmmunitionCreate();
		
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
		imageTitle[0] = "ACE OF HEARTS";
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
	
	public void setImages(ImageView[] image,String[] imageFileName, String[] imageDescription, String[] imageTitle){
		int iterator = 0;
		for(ImageView img:image){
			img.setOnClickListener(new myOnClickListener(context,imageFileName,imageDescription,imageTitle,iterator){
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
						image.setImageResource(R.drawable.ic_launcher);
						return;
					}
					
					Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
					//if button is clicked, close the custom dialog
					dialogButton.setOnClickListener(new OnClickListener(){
						public void onClick(View v){
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
