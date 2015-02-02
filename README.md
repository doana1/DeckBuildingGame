# DeckBuildingGame

Deck Building Game based on the Resident Evil Deck Building Game.

More information on that Deck Building Game can be found from this link.
http://residentevil.wikia.com/Resident_Evil:_The_Deck_Building_Game

Currently implementing the following to this game.
* Main Game
  * Player Hand cards move to Cards Played when used
    * Cards Played move to Discard when turn ends
  * Generate Monsters
    * Generated monsters stored in ArrayList
    * ArrayList can be viewed from a Monster Pile in xml layout
  * Gameplay
    * Track counters when cards are played via Player.class
    * Create condition to determine TurnEnd() and GameEnd()
    * Reset all counters when turn ends

Future Implementations
* Network Play
  * Find players using wifi p2p
