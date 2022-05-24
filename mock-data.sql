-- Setting the path to the correct schema
set search_path to ent_GGCritics;

-- creating some user roles
insert into user_roles (name) values ('ADMIN'), ('BASIC_USER'), ('PREMIUM_USER');

-- creatig a user
insert into app_user (first_name, last_name, email, username, password, role_id)
values ("Luffy", "Monkey", "lmonkey@gmail.com", "lmonkey", "lmonkey", 1);

-- creating some games
insert into game (title, description, average_score, image)
values 
("Eldin Ring", "Rise, Tarnished, and be guided by grace to brandish the power of the Elden Ring and become an Elden Lord in the Lands Between.", 8, "https://specials-images.forbesimg.com/imageserve/5cfbf6b24c687b000859138a/960x0.jpg?fit=scale"),
("Returnal", "After crash-landing on this shape-shifting world, Selene must search through the barren landscape of an ancient civilization for her escape. Isolated and alone, she finds herself fighting tooth and nail for survival. Again and again, she is defeated forced to restart her journey every time she dies.", 8, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.s1SvqJi3U9dhDPXpvHFlMgHaEK%26pid%3DApi&f=1"),
("Grand Theft Auto", "When a young street hustler, a retired bank robber, and a terrifying psychopath find themselves entangled with some of the most frightening and deranged elements of the criminal underworld, the U.S. government, and the entertainment industry, they must pull off a series of dangerous heists to survive in a ruthless city in which they can trust nobody — least of all each other.", 10, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.iAMjCT4qevEmDtWlgoR4VAHaEo%26pid%3DApi&f=1");

-- Creating Reviews for games
insert into review (title, description, average_score, app_user_id, game_id)
values
("A amazing experince","This is one og the best souls games I have ever played. The atmosphere, mixed with the amazing character/boss designs brings everything to life.", 8, 1, 1),
("Very enjoyable", "This game is very challenging but enjoyable at the same time. Shooting the guns paired with a dualsense controller pulls you into the game.", 8, 1, 2),
("Classic", "This game never gets boring even after the story mode; Due to the online mode there is tons of content to get through either by yourself or with friends", 10, 1, 3);