

insert into logs (book, rating, favorite, shelf, content, date, mood, page) values
(9781250762849, 'test1', 5,  'test1', 'test1', null, 'Ok', 100),
(9781250762849, 'test2', 5,  'test2', 'test2', null, 'Ok', 100),
(9781982137441, 'test3', 5,  'test3', 'test3', null, 'Ok', 100);

insert into books (isbn, title, author, thumbnail_url, short_description, status, rating, favorite) values
(9781250762849, 'To Sleep in a Sea of Stars', Christopher Paolini, 'As war erupts among the stars, Kira is launched into a galaxy-spanning odyssey of discovery and transformation. First contact isn't at all what she imagined, and events push her to the very limits of what it means to be human.' 'reading' , null, 0),
(9781982137441, 'In Five Years', 'Rebecca Serle', 'But when she wakes up, she’s suddenly in a different apartment, with a different ring on her finger, and beside a very different man. The television news is on in the background, and she can just make out the scrolling date. It’s the same night—December 15—but 2025, five years in the future.',
'read', 4, 0);