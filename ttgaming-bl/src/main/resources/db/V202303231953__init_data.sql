-- INSERT INTO GAME
INSERT INTO public.GAME (id, RELEASE_YEAR, IMAGE_URL, DURATION, MIN_AGE, MAX_PLAYERS, MIN_PLAYERS, DESCRIPTION, NAME)
VALUES (1,2019,
        'https://stonemaiergames.com/wp-content/uploads/2019/07/3d-tapestry-768x901.png',
        '90 - 120', 12, 5, 1,
        'Create the civilization with the most storied history, starting at the beginning of humankind and reaching into the future. The paths you choose will vary greatly from real-world events or people—your civilization is unique!',
        'Tapestry');

INSERT INTO public.GAME (id, RELEASE_YEAR, IMAGE_URL, DURATION, MIN_AGE, MAX_PLAYERS, MIN_PLAYERS, DESCRIPTION, NAME)
VALUES (2, 2020,
        'https://stonemaiergames.com/wp-content/uploads/2020/06/3D-box-768x915.png',
        '60 - 90', 12, 5, 1,
        'In Pendulum, each player is a powerful, unique noble vying to succeed the Timeless King as the true ruler of Dünya.',
        'Pendulum');

INSERT INTO public.GAME (id, RELEASE_YEAR, IMAGE_URL, DURATION, MIN_AGE, MAX_PLAYERS, MIN_PLAYERS, DESCRIPTION, NAME)
VALUES (3, 2018,
        'https://cdn.shopify.com/s/files/1/0246/2190/8043/t/5/assets/487dbc712165--top-section-product-image-alt.png?v=1581106607',
        '60 - 120', 14, 4, 2,
        'Brass: Birmingham tells the story of competing entrepreneurs in the West Midlands during England''s Industrial Revolution, between the years of 1770-1870.',
        'Brass: Birmingham');

INSERT INTO public.GAME (id, RELEASE_YEAR, IMAGE_URL, DURATION, MIN_AGE, MAX_PLAYERS, MIN_PLAYERS, DESCRIPTION, NAME)
VALUES (4, 2014,
        'https://studiobombyx.com/assets/AbyssBox_3D-600x600.png',
        '45 - 60', 14, 4, 2,
        'For centuries, creatures have enjoyed undivided rule over the depths of the ocean. Their kingdom, Abyss, is respected by all allied nations, happy to have their protection against fearsome underwater monsters. ',
        'Abyss');

INSERT INTO public.GAME (id, RELEASE_YEAR, IMAGE_URL, DURATION, MIN_AGE, MAX_PLAYERS, MIN_PLAYERS, DESCRIPTION, NAME)
VALUES (5, 2015,
        'https://cdn.svc.asmodee.net/production-rprod/storage/games/7-wonders-duel/57du-3dmockup-1597826159KUURt-large.png',
        '30 - 45', 10, 2, 2,
        'In 7 Wonders Duel, each player is leading a civilization and will construct Buildings and Wonders. All of the Buildings constructed by a player together with their Wonders are called a “city. A game plays out over 3 Ages.”',
        '7 Wonders: duel');

INSERT INTO public.GAME (id, RELEASE_YEAR, IMAGE_URL, DURATION, MIN_AGE, MAX_PLAYERS, MIN_PLAYERS, DESCRIPTION, NAME)
VALUES (6, 2021,
        'https://images.zmangames.com/filer_public/34/40/3440fabc-0479-4796-b469-89d03d3012e9/zm7125_box_front_520px.png',
        '45 - 60', 14, 5, 1,
        'In World of Warcraft: Wrath of the Lich King – A Pandemic System Board Game, take on the roles of the legends of the World of Warcraft universe and lead the invasion of Northrend! ',
        'World of Warcraft: Wrath of The Lich King');

-- INSERT INTO EXPANSIONS
INSERT INTO public.EXPANSIONS(id, BASE_GAME_ID, IMAGE_URL, RELEASE_DATE, DESCRIPTION, NAME)
VALUES (1, (SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'),
        'https://stonemaiergames.com/wp-content/uploads/2021/06/3d-tapestry-plans-768x1024.png', 2020,
        'Choose from a variety of new civilizations, pursue individual achievements to add landmarks to your capital city, and sneakily interact with the opposition in this first expansion for Tapestry.',
        'Tapestry: Plans & Ploys');

INSERT INTO public.EXPANSIONS(id, BASE_GAME_ID, IMAGE_URL, RELEASE_DATE, DESCRIPTION, NAME)
VALUES (2, (SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'),
        'https://stonemaiergames.com/wp-content/uploads/2021/10/3d-tapestry-arts-768x1010.png', 2021,
        'Choose from a variety of new capital city mats, a new advancement track featuring new types of cards and tiles, plus more civilizations, tapestry cards, tech cards, and landmark miniatures/cards in this second expansion for Tapestry.',
        'Tapestry: Arts & Architecture');

INSERT INTO public.EXPANSIONS(id, BASE_GAME_ID, IMAGE_URL, RELEASE_DATE, DESCRIPTION, NAME)
VALUES (3, (SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'),
        'https://stonemaiergames.com/wp-content/uploads/2023/01/box-flat-no-legal-768x896.png', 2023,
        'Parallel universes are abundant in the world of Tapestry. The Fantasies & Futures expansion gives players the opportunity to build civilizations using fantasy and sci-fi inspired civs, technology, tapestries, and cities.',
        'Tapestry: Fantasies & Futures');

INSERT INTO public.EXPANSIONS(id, BASE_GAME_ID, IMAGE_URL, RELEASE_DATE, DESCRIPTION, NAME)
VALUES (4, (SELECT ID FROM public.GAME WHERE NAME = 'Abyss'),
        'https://studiobombyx.com/assets/Kraken_3Dbox-600x600.png', 2015,
        'The struggle for power in the Kingdom of Abyss is more fierce than ever before. Corruption has begun to spread its evil tentacles across the once pure land. ',
        'Abyss: Kraken');

INSERT INTO public.EXPANSIONS(id, BASE_GAME_ID, IMAGE_URL, RELEASE_DATE, DESCRIPTION, NAME)
VALUES (5, (SELECT ID FROM public.GAME WHERE NAME = 'Abyss'),
        'https://studiobombyx.com/assets/Leviathan_3Dbox-600x600.png', 2018,
        'News coming from the outposts are disturbing. The Leviathans, terrifying marine monsters from the forgotten zones of the Abyss, are gathering on the border and threaten the Kingdom.',
        'Abyss: Leviathan');

INSERT INTO public.EXPANSIONS(id, BASE_GAME_ID, IMAGE_URL, RELEASE_DATE, DESCRIPTION, NAME)
VALUES (6, (SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'),
        'https://cdn.svc.asmodee.net/production-rprod/storage/extensions/7WD-agora/ag-mu-3d-box-left-1594914184we7rA.png', 2020,
        'This expansion for 7 Wonders Duel adds Senators and their influence on the Senate. Try to control these Chambers to benefit from Decrees or call on Conspirators who could very well overthrow the situation.',
        '7 Wonders: Agora');

INSERT INTO public.EXPANSIONS(id, BASE_GAME_ID, IMAGE_URL, RELEASE_DATE, DESCRIPTION, NAME)
VALUES (7, (SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'),
        'https://cdn.svc.asmodee.net/production-rprod/storage/extensions/7WD-pantheon/7wdp-box-3d-left-1594920845W3ccH.png', 2016,
        'This expansion for 7 Wonders Duel offers players the ability to invoke powerful Divinities to benefit from their powers',
        '7 Wonders: Pantheon');

-- INSERT INTO PUBLISHER
INSERT INTO public.PUBLISHER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (1, 'https://stonemaiergames.com/',
        'Stonemaier Games is a tabletop game publisher run by Jamey Stegmaier with the support of co-founder Alan Stone.',
        'Stonemaier');

INSERT INTO public.PUBLISHER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (2, 'https://roxley.com/',
        'Roxley''s unending quest is to conquer the minds of humanity, with the most innovative, addictive, beautiful, polished, replayable games you''ll experience.',
        'Roxley');

INSERT INTO public.PUBLISHER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (3, 'https://studiobombyx.com/en/',
        'French publishing house of board games. We offer quick and clever games for the whole family or more complex games for experienced players.',
        'Bombyx');

INSERT INTO public.PUBLISHER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (4, 'https://www.rprod.com/en',
        'Having published over 60 games since 2004, we have only one vocation: to give you unforgettable moments with family and friends playing our board games!',
        'Repos production');

INSERT INTO public.PUBLISHER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (5,  'https://www.zmangames.com/en/index/',
        'At Z-Man Games, we create innovative games that become modern essentials.',
        'Z-man Games');

INSERT INTO public.PUBLISHER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (6, 'https://www.blizzard.com/en-us/',
        'At Blizzard Entertainment, we pour our hearts and souls into everything we create. We embrace our core values every day so that we can continue creating epic entertainment experiences for all our players.',
        'Blizzard Entertainment');

-- INSERT INTO GAME_PUBLISHERS
INSERT INTO public.GAME_PUBLISHERS(GAME_ID, PUBLISHER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.PUBLISHER WHERE NAME = 'Stonemaier'));
INSERT INTO public.GAME_PUBLISHERS(GAME_ID, PUBLISHER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Pendulum'), (SELECT ID FROM public.PUBLISHER WHERE NAME = 'Stonemaier'));
INSERT INTO public.GAME_PUBLISHERS(GAME_ID, PUBLISHER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.PUBLISHER WHERE NAME = 'Roxley'));
INSERT INTO public.GAME_PUBLISHERS(GAME_ID, PUBLISHER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.PUBLISHER WHERE NAME = 'Bombyx'));
INSERT INTO public.GAME_PUBLISHERS(GAME_ID, PUBLISHER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.PUBLISHER WHERE NAME = 'Repos production'));
INSERT INTO public.GAME_PUBLISHERS(GAME_ID, PUBLISHER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.PUBLISHER WHERE NAME = 'Z-man Games'));
INSERT INTO public.GAME_PUBLISHERS(GAME_ID, PUBLISHER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.PUBLISHER WHERE NAME = 'Blizzard Entertainment'));

-- INSERT INTO CATEGORY
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (1, 'Civilisation');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (2, 'Strategy');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (3,'Card game');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (4,'Economic');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (5, 'Industry / Manufacturing');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (6,'Post-napoleonic');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (7,'Trains');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (8,'Transportation');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (9,'Fantasy');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (10,'Mythology');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (11,'Science fiction');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (12,'Ancient');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (13,'City building');
INSERT INTO public.CATEGORY(ID, NAME)
VALUES (14,'Video game theme');

-- INSERT INTO GAME_CATEGORIES
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Civilisation'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Strategy'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Pendulum'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Card game'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Pendulum'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Economic'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Economic'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Industry / Manufacturing'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Post-napoleonic'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Trains'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Transportation'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Card game'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Fantasy'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Mythology'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Science fiction'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Ancient'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Card game'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'City building'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Civilisation'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Economic'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Fantasy'));
INSERT INTO public.GAME_CATEGORIES(GAME_ID, CATEGORY_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.CATEGORY WHERE NAME = 'Video game ' ||
                                                                                                                                            'theme'));

-- INSERT INTO DESIGNER
INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (1,'https://stonemaiergames.com/about/staff/jamey-stegmaier/',
        'Runs the day-to-day operations of Stonemaier Games',
        'Jamey Stegmaier');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (2,'https://www.bosleyart.com/',
        'Been making illustrations for board games like Everdell, Tapestry, and Citadels as well as making concepting for video games like Paladins, Ghost Recon, and Assassin''s Creed.',
        'Andrew Bosley');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (3,'https://boardgamegeek.com/boardgameartist/73222/rom-brown',
        'A New Zealand artist whose illustrative work appears in the fanzine "Underworld Lore", the Expanded "Petty Gods" Compendium and "Quack Keep", and whose sculptures appear in the Stonemaier game: Tapestry.',
        'Rom Brown');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (4,'https://boardgamegeek.com/boardgamepublic.DESIGNER/120672/travis-jones',
        'Travis Jones is a Computer Engineer living in King of Prussia, PA. When he’s not working or spending time with his wife, he’s designing board games. Whether creating software or board games he loves the process of designing amazing things.',
        'Travis Jones');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (5,'https://boardgamegeek.com/boardgameartist/127611/robert-leask',
        'Robert is an Irish artist who enjoys creating colourful and detailed fantastical worlds, stories and characters.',
        'Robert Leask');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (6,'https://boardgamegeek.com/boardgamedesigner/32943/matt-tolman',
        'Matt Tolman is a member of the Game Artisans of Canada (www.gameartisans.ca). He has been an avid gamer his whole life and started designing games in 2007.',
        'Matt Tolman');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (7,'https://en.wikipedia.org/wiki/Martin_Wallace_(game_designer)',
        'Wallace is the founder and chief designer of Treefrog (former Warfrog) Games. Wallace is known for designing complex strategy games that depict a variety of historical settings.',
        'Martin Wallace');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (8,'https://boardgamegeek.com/boardgamedesigner/32887/gavan-brown',
        'Gavan Brown is a game designer and runner located in Calgary, Canada. Gavan is a member of the Game Artisans of Canada, and runs the independent game design boutique, Roxley Game Laboratory.',
        'Gavan Brown');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (9,'https://www.brunocathala.com/',
        'Game professional in all its forms, whether as an author for the board game market that everyone can find in their favorite store, but also as a ' ||
        'consultant / animator / designer for tailor-made services.',
        'Bruno Cathala');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (10,'https://boardgamegeek.com/boardgamedesigner/34672/charles-chevallier',
        'French architect and game designer.',
        'Charles Chevallier');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (11,'https://www.xaviercollette.com/',
        'An artist from Belgium who provided artwork for the role-playing game Kuro and board game Abyss',
        'Xavier Collette');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (12,'http://www.antoinebauza.fr/',
        'Popular designer of several award-winning games, including 7 Wonders and Hanabi, also well-known for his many other games, including Ghost Stories and Tokaido.',
        'Antoine Bauza');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (13,'https://boardgamegeek.com/boardgamedesigner/85379/alexandar-ortloff',
        'Game Designer at Z-Man Games. Designer of Marvel Infinity Gauntlet: A Love Letter Game.',
        'Alexandar Ortloff');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (14,'https://boardgamegeek.com/boardgamedesigner/72460/justin-kemppainen',
        'Lead designer for Leviathan Wilds and one of the founders of Moon Crab Games. Former designer/manager at Z-Man Games and FFG.',
        'Justin Kemppainen');

INSERT INTO public.DESIGNER(ID, WEBSITE_URL, DESCRIPTION, NAME)
VALUES (15,'https://boardgamegeek.com/boardgamedesigner/138487/michael-sanfilippo',
        'Game designer',
        'Michael Sanfilippo');

-- INSERT INTO GAME_DESIGNERS
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Jamey Stegmaier'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Andrew Bosley'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Rom Brown'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Pendulum'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Travis Jones'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Pendulum'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Robert Leask'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Matt Tolman'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Martin Wallace'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Gavan Brown'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Bruno Cathala'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Charles Chevallier'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Xavier Collette'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Antoine Bauza'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Bruno Cathala'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Alexandar Ortloff'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Justin Kemppainen'));
INSERT INTO  public.GAME_DESIGNERS(GAME_ID, DESIGNER_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.DESIGNER WHERE NAME = 'Michael Sanfilippo'));

-- INSERT INTO MECHANIC
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (1,'Dice rolling');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (2,'Hand management');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (3,'Income');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (4,'Solo game');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (5,'Push your luck');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (6,'Tile placement');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (7,'Deck construction');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (8,'Worker placement');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (9,'Loans');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (10,'Market');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (11,'Auction / bidding');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (12,'Memory');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (13,'Layering');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (14,'Set collection');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (15,'Open drafting');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (16,'Variable player powers');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (17,'Thug of war');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (18,'Point to point movement');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (19,'Trading');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (20,'Co-operative play');
INSERT INTO  public.MECHANIC(ID, NAME)
VALUES (21,'Action point');

-- INSERT INTO GAME_MECHANICS
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Dice rolling'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Hand management'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Income'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Solo game'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Push your luck'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Tile placement'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Pendulum'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Deck construction'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Pendulum'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Solo game'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Pendulum'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Worker placement'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Hand management'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Income'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Loans'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Market'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Auction / bidding'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Hand management'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Memory'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Push your luck'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Layering'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Set collection'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Auction / bidding'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Variable player powers'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = '7 Wonders: duel'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Thug of war'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Set collection'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'Abyss'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Open drafting'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Point to point movement'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Variable player powers'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Trading'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Co-operative play'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Hand management'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Set collection'));
INSERT INTO  public.GAME_MECHANICS(GAME_ID, MECHANIC_ID)
VALUES ((SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'), (SELECT ID FROM public.MECHANIC WHERE NAME = 'Action point'));

-- INSERT INTO USER
INSERT INTO public.TTGUSER (ID, UPDATED_AT, CREATED_AT, PASSWORD, EMAIL, USERNAME)
VALUES (1,NOW(), NOW(), 'Problema123', 'problema@gmail.com', 'problema');

-- INSERT INTO REVIEW
INSERT INTO public.REVIEW(ID, UPDATED_AT, CREATED_AT, COMMENT, RATING, GAME_ID, USER_ID)
VALUES (1,NOW(), NOW(), 'Nieko ypatingo', 2, (SELECT ID FROM public.GAME WHERE NAME = 'Scythe'), (SELECT ID FROM public.TTGUSER WHERE USERNAME = 'problema'));

-- INSERT INTO USER_WISHLIST
INSERT INTO public.USER_WISHLIST(USER_ID, GAME_ID)
VALUES ((SELECT ID FROM public.TTGUSER WHERE USERNAME = 'problema'), (SELECT ID FROM public.GAME WHERE NAME = 'World of Warcraft: Wrath of The Lich King'));

-- INSERT INTO USER_COLLECTION
INSERT INTO public.USER_COLLECTION(USER_ID, GAME_ID)
VALUES ((SELECT ID FROM public.TTGUSER WHERE USERNAME = 'problema'), (SELECT ID FROM public.GAME WHERE NAME = 'Tapestry'));
INSERT INTO public.USER_COLLECTION(USER_ID, GAME_ID)
VALUES ((SELECT ID FROM public.TTGUSER WHERE USERNAME = 'problema'), (SELECT ID FROM public.GAME WHERE NAME = 'Brass: Birmingham'));