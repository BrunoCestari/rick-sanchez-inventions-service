CREATE TABLE inventions (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  category VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  description TEXT,
  name VARCHAR(255) NOT NULL,
  price DOUBLE NOT NULL
);


INSERT INTO `inventions` (`name`, `category`, `description`, `price`, created_at) VALUES
('Space Cruiser', 'Vehicle', 'Rick''s space cruiser is a flying vehicle (especially car) created by Rick. Rick pieced the ship together from materials found in the garage of the Smith Residence. The ship is shaped like a UFO and features wheels on the underside for landings. The interior of the ship is commonly full of empty bottles of alcohol.', 1500000, CURRENT_TIMESTAMP),
('Neutrino Bomb', 'Weapon', 'The neutrino bomb was a powerful bomb invented by Rick in the Pilot episode, that presumably radiates a lethal amount of neutrinos when detonated. Because neutrinos can pass through matter almost unimpeded, a sufficient intensity of neutrinos will travel through the earth and deliver a lethal dose to the entire population in a fraction of a second.', 5000000, CURRENT_TIMESTAMP),
('Portal Gun', 'Weapon', 'The Portal Gun is Rick''s most-used invention. It is a gun that shoots green, fluidic portals onto any surface and allows the user(s) to travel between different universes, dimensions and realities. Initially built by Rick for travel to and from Dimension C-137. Due to the infinite number of locations, one could use the portal gun to travel anywhere.', 50000000, CURRENT_TIMESTAMP),
('Freeze Ray', 'Weapon', 'The Freeze ray was one of Rick''s devices. It could freeze organic targets until they became an icy statue. The effects were reversible but made the target extremely fragile and prone to shattering. Frank Palicky was killed when Rick froze him with the ray and he subsequently shattered when he was tipped over. In the Rick and Morty Simpsons couch gag, it is used on the Simpsons'' neighbor, Ned Flanders.', 2000000, CURRENT_TIMESTAMP),
('Cognition Amplifier', 'Device', 'The Cognition Amplifier is a helmet that can increase the intelligence of anything that wears it. In the episode ''Lawnmower Dog,'' Rick used it on Snuffles to make him intelligent enough to understand and better communicate with humans.', 1000000, CURRENT_TIMESTAMP),
('Dream Inceptor', 'Device', 'The dream inceptor is an earpiece that allows its users to transport their consciousness inside of other people''s dreams. One of them goes on the ear of a sleeping person, and the other goes on someone else. When activated, they will both go to sleep and be sent into the same dream realm together.', 3500000, CURRENT_TIMESTAMP),
('Shrink Ray', 'Weapon', 'Rick''s shrink ray was a complex device that could shrink a human down to microscopic size in the episode ''Anatomy Park.'' Rick used this to shrink Morty, so he could enter Ruben''s body and save Dr. Xenon Bloom who was having difficulty with problems in Anatomy Park, located inside Ruben. Its counterpart, a growth/enlarge ray, is located inside of Ruben in the colon.', 3000000, CURRENT_TIMESTAMP),
('Dark Matter', 'Device', 'Dark matter is a form of matter that has been unsolved by scientists. Rick knows the formula on how to create concentrated dark matter as a fuel source to enable faster space travel, and the formula is a secret that the Zigerions have long sought to steal from him. However, in the episode ''M. Night Shaym-Aliens!,'' he fooled the Zigerions into believing that the formula included water and cesium. When they attempted to follow his fake recipe, Rick had escaped and the Zigerions had blown themselves up.', 4000000, CURRENT_TIMESTAMP),
('Meeseeks Box', 'Device', 'The Meeseeks Box is a box that is able to create a Meeseeks which will stop at nothing to complete simple tasks. Meeseeks Boxes don''t seem to have been created by Rick as Mr. Meeseeks has been seen through the galaxy.', 1000000, CURRENT_TIMESTAMP),
('Ionic Defibulizer', 'Device', 'The ionic defibulizer was an invention with an unknown purpose seen in the episode Rick Potion 9. It exploded however, upon completion, killing both the Rick and the Morty of the dimension in which it was finished.', 2000000, CURRENT_TIMESTAMP),
('Demonic Alien Containment Box', 'Device', 'The demonic alien containment box was used in the episode Meeseeks and Destroy. It''s a box that can capture the demonic spirits that were possessing the clones of Beth, Summer, and Jerry so that they would not possess anyone else''s bodies. It may be a parody on the ghost traps from Ghostbusters.', 1500000, CURRENT_TIMESTAMP),
('Love Potion', 'Potion', 'In the episode ''Rick Potion #9,'' Rick gave Morty a potion that would make Jessica fall in love with him. The potion is extracted from a vole and the DNA from a strand of Morty''s hair. The love potion would work on anyone it infects except for people who are genetically related to him. If this is used on someone with the flu, it will piggyback on the influenza and become a contagious pathogen, spreading and causing everyone in the world except the Smith family to fall completely in love with Morty.', 3000000, CURRENT_TIMESTAMP),
('Love Antidote', 'Potion', 'Rick used a gaseous antidote on the city''s population to turn them back to normal again, but he messed up somewhere and turned them all into mantis-men that were still in love with Morty and now wanted to eat his head. His first attempt at an antidote resulted in this because of Rick reasoning that since praying mantis females eat their mate''s head while mating, praying mantis DNA should be the main ingredient in an anti-love potion. The second attempt included many more genetic samples from a menagerie of organisms, wrongly assuming that using it on the infatuated mantis-men would restore their humanity.', 2500000, CURRENT_TIMESTAMP),
('Inter Dimensional Cable', 'Device', 'In the episode ''Rixty Minutes'', Rick installed this after complaining about the quality of TV and Jerry challenges him to provide anything better, installing a cable box that shows television from every conceivable reality.', 4000000, CURRENT_TIMESTAMP),
('Interdimensional Goggles', 'Device', 'The goggles work by synching the user''s eyes to the genetic code found across countless realities. When the user wears the goggles, they see their alternate dimension lives in the first-person.', 2000000, CURRENT_TIMESTAMP),
('Curse Detector', 'Device', 'A detector made by Rick via analyzing a cursed microscope which would have lowered his IQ. This invention detects curses.', 500000, CURRENT_TIMESTAMP),
('House Transporter', 'Device', 'A device made by Rick, which when broken, transported the entire house to dimension 35-C.', 1500000, CURRENT_TIMESTAMP),
('Time Stopper', 'Device', 'A device that stops time. Rick used it to give him, Morty, and Summer time to repair the house.', 3000000, CURRENT_TIMESTAMP),
('Split Possibility Detector', 'Device', 'A device that detects split possibilities, enabling users to understand alternative outcomes and scenarios in various situations.', 4000000, CURRENT_TIMESTAMP),
('Translator', 'Device', 'A device that changes any language to English.', 1000000, CURRENT_TIMESTAMP),
('Particle Beam Wrist Watch', 'Weapon', 'Introduced in ''Get Schwifty,'' this watch fires a green blast that vaporizes a target near instantly, while Rick also used a snake holster on his leg to release snakes while he fired to make it appear that the watch turned its victims into snakes.', 3500000, CURRENT_TIMESTAMP),
('Microverse Battery', 'Device', 'The microverse battery is a gadget developed by Rick to supply power to his flying ship. It contains a miniature universe in which some organic and intelligent life has developed. Rick introduced electricity to the miniature planet inside the Microverse in form of kinetic devices which the inhabitants then use to power their homes and devices, and unknowingly, Rick''s car.', 5000000, CURRENT_TIMESTAMP),
('Sanchez Ski Shoes', 'Device', 'Specialized shoes designed for extreme conditions, allowing Rick to perform in high-speed and challenging environments.', 1500000, CURRENT_TIMESTAMP),
('Operation Phoenix', 'Device', 'Operation Phoenix was a secret cloning project created by Rick that could be found underneath the garage of the Smith Residence. Rick originally designed it as a fail-safe that transfers his brain into one of the many cloned bodies of himself whenever he gets killed.', 10000000, CURRENT_TIMESTAMP),
('Combat Suit', 'Armor', 'The Combat Suit is a full-body armor (except for the face) that protects the user from basic contusion/cutting weapons, as well as enhances the user''s strength and resilience to inhuman levels. It also includes missiles, energy guns, a flame thrower, a non-lethal electrical blast, arm-mounted melee blades, and a rocket propulsion system.', 8000000, CURRENT_TIMESTAMP),
('Wooden Combat Suits', 'Armor', 'A separate pair of primarily wooden combat suits appears in ''The Ricks Must Be Crazy,'' created by Rick and Zeep Xanflorp in the Tinyverse to stalk wildlife and attack each other.', 2000000, CURRENT_TIMESTAMP),
('Futuristic Guns', 'Weapon', 'Rick has his own ray guns or laser guns that he most surely created himself. Rick''s personal sidearm fires a red or green energy bolt that can either mutilate a target with bloody wounds or vaporize them. Some guns can even cause a target to explode into gore.', 3000000, CURRENT_TIMESTAMP),
('Ray Gun', 'Weapon', 'A versatile weapon used by Rick, capable of firing powerful energy blasts.', 2500000, CURRENT_TIMESTAMP),
('Muscle Injector', 'Device', 'An injector designed to enhance muscle growth and physical capabilities instantly.', 1500000, CURRENT_TIMESTAMP),
('Epidermis Nanomesh', 'Armor', 'A nanomesh designed to enhance the wearer''s skin, making it more resistant to damage and environmental effects.', 2000000, CURRENT_TIMESTAMP),
('Impregnation Gun', 'Device', 'A specialized gun that uses advanced technology to influence reproductive processes.', 2000000, CURRENT_TIMESTAMP),
('Voltron Drones', 'Device', 'Advanced drones equipped with high-tech capabilities for various tactical operations.', 3500000, CURRENT_TIMESTAMP),
('Memory Eraser', 'Device', 'A device that can erase specific memories from an individual''s mind.', 2500000, CURRENT_TIMESTAMP),
('Bubble Gum', 'Device', 'Special bubble gum with unique properties that can alter reality or provide special effects.', 1000000, CURRENT_TIMESTAMP),
('Attachable Robot Arm', 'Device', 'A robotic arm that can be attached to various surfaces or worn by users for enhanced functionality.', 1500000, CURRENT_TIMESTAMP),
('Whip', 'Weapon', 'A versatile whip with advanced technology for combat or utility purposes.', 1000000, CURRENT_TIMESTAMP),
('Invisibility Cuffs', 'Device', 'Cuffs that render the wearer invisible, ideal for stealth operations.', 2000000, CURRENT_TIMESTAMP);
