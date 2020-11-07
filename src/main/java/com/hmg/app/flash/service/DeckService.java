package com.hmg.app.flash.service;

import java.time.LocalDate;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;

import com.hmg.app.flash.api.util.DeckVisibility;
import com.hmg.app.flash.model.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeckService {
    private static final Logger log = LoggerFactory.getLogger(DeckService.class);

	

	public Deck fetchDeckForId(ObjectContext ctx,String deckId) {
		log.debug("fetch deck with id:"+deckId);
		Deck aDeck = ObjectSelect.query(Deck.class).where(Deck.DECK_ID.eq(deckId)).selectFirst(ctx);
		return aDeck;
	}
	
	public Deck newDeck(ObjectContext ctx, String deckId) {
		log.debug("New deck with id:"+deckId);
		Deck deck = ctx.newObject(Deck.class);
		deck.setCreateDate(LocalDate.now());
		deck.setDeckId(deckId);
		deck.setVisibility(DeckVisibility.PRIVATE);
		deck.setQuestionCount(0);
		try {
			ctx.commitChanges();
		}catch(Exception e) {
			
		}
		return deck;
	}

}
