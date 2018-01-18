import { Injectable } from '@angular/core';
import { Book } from './book';

@Injectable()
export class BookService {

  constructor() { }
  
  getBooks(): Book[] {
    return books;
  }
  
  getBookById(bookId: number) {    
    return books.find(b => b.id === bookId);
  }

}

const books = [
  {
    id: 1,
    title: 'Fire and Fury: Inside the Trump White House',
    author: 'Michael Wolff',
    description: 'The first nine months of Donald Trump’s term were stormy, outrageous—and absolutely mesmerizing. Now, thanks to his deep access to the West Wing, bestselling author Michael Wolff tells the riveting story of how Trump launched a tenure as volatile and fiery as the man himself.',
    publishedDate: new Date('2018-01-05'),
    price: 30.00,
    discount: null
  },
  {
    id: 2,
    title: 'Harry Potter and the Sorcerer\'s Stone',
    author: 'J. K. Rowling',
    description: 'Harry Potter has never been the star of a Quidditch team, scoring points while riding a broom far above the ground. He knows no spells, has never helped to hatch a dragon, and has never worn a cloak of invisibility.  All he knows is a miserable life with the Dursleys, his horrible aunt and uncle, and their abominable son, Dudley - a great big swollen spoiled bully. Harry\'s room is a tiny closet at the foot of the stairs, and he hasn\'t had a birthday party in eleven years.  But all that is about to change when a mysterious letter arrives by owl messenger: a letter with an invitation to an incredible place that Harry - and anyone who reads about him - will find unforgettable.  For it\'s there that he finds not only friends, aerial sports, and magic in everything from classes to meals, but a great destiny that\'s been waiting for him... if Harry can survive the encounter.',
    publishedDate: new Date('1999-09-08'),
    price: 10.99,
    discount:  9.99
  },
  {
    id: 3,
    title: 'The Davinci Code',
    author: 'Dan Brown',
    description: 'While in Paris on business, Harvard symbologist Robert Langdon receives an urgent late-night phone call: the elderly curator of the Louvre has been murdered inside the museum. Near the body, police have found a baffling cipher. While working to solve the enigmatic riddle, Langdon is stunned to discover it leads to a trail of clues hidden in the works of Da Vinci -- clues visible for all to see -- yet ingeniously disguised by the painter.  Langdon joins forces with a gifted French cryptologist, Sophie Neveu, and learns the late curator was involved in the Priory of Sion -- an actual secret society whose members included Sir Isaac Newton, Botticelli, Victor Hugo, and Da Vinci, among others.  In a breathless race through Paris, London, and beyond, Langdon and Neveu match wits with a faceless powerbroker who seems to anticipate their every move. Unless Langdon and Neveu can deipher the labyrinthine puzzle in time, the Priory\'s ancient secret -- and an explosive historical truth -- will be lost forever.',
    publishedDate: new Date('2006-03-28'),
    price: 14.95,
    discount: null
  },
  {
    id: 4,
    title: 'Digital Fortress',
    author: 'Dan Brown',
    description: 'When the NSA\'s invincible code-breaking machine encounters a mysterious code it cannot break, the agency calls its head cryptographer, Susan Fletcher, a brilliant, beautiful mathematician. What she uncovers sends shock waves through the corridors of power. The NSA is being held hostage--not by guns or bombs -- but by a code so complex that if released would cripple U.S. intelligence. Caught in an accelerating tempest of secrecy and lies, Fletcher battles to save the agency she believes in. Betrayed on all sides, she finds herself fighting not only for her country but for her life, and in the end, for the life of the man she loves. ',
    publishedDate: new Date('2008-11-04'),
    price: 9.99,
    discount: null
  },
  {
    id: 5,
    title: 'Watchmen',
    author: 'Alan Moore',
    description: 'Watchmen is set in an alternate reality that closely mirrors the contemporary world of the 1980s. The primary difference is the presence of superheroes. The point of divergence occurs in the year 1938. Their existence in this version of America is shown to have dramatically affected and altered the outcomes of real-world events such as the Vietnam War and the presidency of Richard Nixon. In keeping with the realism of the series, although the costumed crimefighters of Watchmen are commonly called "superheroes", only one (Doctor Manhattan) possesses any superhuman powers. The war in Vietnam ends with a U.S. victory in 1971 and Nixon is still president as of October 1985. The Soviet invasion of Afghanistan occurs approximately six years later than in real life. When the story begins, the existence of Doctor Manhattan has given the U.S. a strategic advantage over the Soviet Union, which has increased tensions between the two nations. Eventually, superheroes grow unpopular among the police and the public, leading to the passage of legislation (the Keene Act) in 1977 to outlaw them. While many of the heroes retired, Doctor Manhattan and a veteran superhero known as The Comedian operate as government-sanctioned agents. Another, Rorschach, continues to operate outside the law.',
    publishedDate: new Date('2014-05-13'),
    price: 19.99,
    discount:  14.99
  },
  {
    id: 6,
    title: 'The Divine Comedy',
    author: 'Dante Alighieri',
    description: 'A landmark of world literature, The Divine Comedy tells of the poet Dante\'s travels through Hell, Purgatory, and Paradise in search of salvation. Before he is redeemed by his love for the heavenly Beatrice, he learns the meaning of evil, sin, damnation, and forgiveness through a series of unforgettable experiences and encounters. This edition of The Divine Comedy features Henry Wadsworth Longfellow\'s renowned translation and 135 full-page reproductions of Gustave Doré\'s classic engravings from the 1867 edition. The Divine Comedy is one of Barnes and Noble\'s Collectible Editions classics. Each volume features authoritative texts by the world\'s greatest authors in an exquisitely designed bonded-leather binding, with distinctive gilt edging and a ribbon bookmark. Decorative, durable, and collectible, these books offer hours of pleasure to readers young and old and are an indispensable cornerstone for every home library.',
    publishedDate: new Date('2016-06-01'),
    price: 20.00,
    discount: null
  },
  {
    id: 7,
    title: 'The Ultimate Hitchhiker\'s Guide to the Galaxy',
    author: 'Douglas Adams' ,
    description: 'Your planet has just been destroyed and you’re lost in the space-time continuum, but—Don’t Panic! Just thumb your way to the end of the universe for a nice cuppa tea with the help of The Ultimate Hitchhiker’s Guide to the Galaxy, your Baedeker for intergalactic zaniness. Featuring all five novels in Douglas Adams’s beloved Hitchhiker’s series—The Hitchhiker’s Guide to the Galaxy; The Restaurant at the End of the Universe; Life, the Universe and Everything; So Long, and Thanks for All the Fish; Mostly Harmless—and the bonus short story “Young Zaphod Plays It Safe", this omnibus provides you with the perfect itinerary for sightseeing across the universe, from the beginning to the end of time. Along the way you’ll meet paranoid robots, avert Armageddon (more than once!), and learn the answer to the ultimate question concerning life, the universe, and everything—even though you’ll never learn what the question is. So strap in, get ready for lift-off, and prepare yourself for comedy on a cosmic scale.  The Ultimate Hitchhiker’s Guide to the Galaxy is one of Barnes and Noble’s Collectible Editions classics. Each volume features authoritative texts by the world’s greatest authors in exquisitely designed bonded-leather bindings with distinctive gilt edging and an attractive ribbon bookmark. Decorative, durable, and collectable, these books offer hours of pleasure to readers young and old and are an indispensable cornerstone for any home library.',
    publishedDate: new Date('2010-10-25'),
    price: 25.00,
    discount:  20.00
  },
  {
    id: 8,
    title: 'The Complete Tales and Poems of Edgar Allen Poe',
    author: 'Edgar Allen Poe',
    description: 'Edgar Allan Poe is credited with having pioneered the short story, having perfected the tale of psychological horror, and having revolutionized modern poetics. The entirety of Poe\'s body of imaginative work encompasses detective tales, satires, fables, fantasies, science fiction, verse dramas, and some of the most evocative poetry in the English language. This leatherbound omnibus collects all of Poe\'s fiction and poetry in a single volume, including "The Fall of the House of Usher", "The Tell-Tale Heart", "The Pit and the Pendulum", "The Raven", and "Annabel Lee" the full-length novel The Narrative of Arthur Gordon Pym of Nantucket, and much more.  The Complete Tales and Poems of Edgar Allan Poe is part of Barnes and Noble\'s Collectible Editions series. Each title in the series presents a classic work in an attractively designed edition bound in genuine bonded leather. These books make elegant additions to any home library.',
    publishedDate: new Date('2015-07-31'),
    price: 25.00,
    discount: null
  }
]
