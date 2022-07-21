
insert into  shelves(id,name)
values (1, 'fiction'), (2,'to re-read'), (3, 'never to finish');


insert into books(id, title, author, thumbnail_url, short_description, status, rating, favorite, start_date, finished_date)
values
(1,  'To Sleep in a Sea of Stars', 'Christopher Paolini',
'https://covers.openlibrary.org/b/id/12641483-M.jpg',
 'xxx', 'reading', 0, 0, '2022-07-12 00:00:00', '2022-07-12 00:00:00'),

(2,  'Great North Road', 'Peter F. Hamilton',
'https://covers.openlibrary.org/b/id/10416636-M.jpg',
'xxx', 'reading', 0, 0, '2022-07-12 00:00:00', '2022-07-12 00:00:00'),

(3,  'Pachinko', 'Lee Min-jin',
'https://covers.openlibrary.org/b/id/11301913-M.jpg',
'xxx', 'read', 4, 0, '2022-07-12 00:00:00', '2022-07-12 00:00:00'),

(4,  'Love Lettering', 'Kate Clayborn',
'https://covers.openlibrary.org/b/id/9255246-M.jpg',
'xxx', 'read', 3, 0, '2022-07-12 00:00:00', '2022-07-12 00:00:00'),

(5,  'Dear Emmie Blue', 'Lia Louis',
'https://covers.openlibrary.org/b/id/10328244-M.jpg',
'xxx', 'read', 5, 1, '2022-07-12 00:00:00', '2022-07-12 00:00:00');



insert into logs(id,shelf,content,date,mood,page,book_id)
values
(1, 'romance', 'My heart went all puffy! Glad I found this after I had a similar dream hahahaha I actually started to read it because I wanted to see how the dream ended, and this book was exactly that feeling!',
 '2022-07-08', 'Excited', 320,5),
(2,'romance', 'Honestly no idea how this plot is building... And I don''t like Reid. It''s like a weird perfect emotionless Ken doll brought to life.',
'2022-07-08', 'Weird', 55, 4 ),
(3,'romance', 'I really do not understand what they are doing! And what is Reid supposed to do?',
'2022-07-08', 'Weird', 60, 4 ),
(4,'romance', 'Still wondering why I''m reading this. It''s sweet. But I remember why I don''t like random romance... Note to self. But I''m still curious. So I keep reading.',
'2022-07-08', 'Weird', 189, 4 ),
(5,'romance', 'OK. Not my cup of tea.',
'2022-07-08', 'Weird', 307, 4 ),
(6, 'Historical', 'I enjoyed it, except the last chapters… they were dry.',
'2022-07-08', 'Happy', 537, 3),
(7, 'SciFi', '19/2 Starts with Sid and his partner Ian solving a muddler crime. Sid sounds old, tired from jokes and very empathic. Same night, the murder of one of the clones.
20/2 kids 8 & 6. Small house to big house. Jacinta a health hobbyist.- Zone room?- Economy : bioil',
'2022-07-08', 'Ok', 25, 2);

insert into shelved_books(books_id, shelves_id)
values
(1, 1),
(2,1),
(2,2),
(2,3),
(3,2);
