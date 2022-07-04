insert into books(id, OLid, title, author, thumbnail_url, short_description, status, rating, favorite, start_date, finished_date)
values
(1, 123, 'Life', 'xxx', 'https://d1csarkz8obe9u.cloudfront.net/posterpreviews/action-thriller-book-cover-design-template-3675ae3e3ac7ee095fc793ab61b812cc_screen.jpg?ts=1637008457', 'xxx', 'reading', 0, 0, 'xxx', 'xxx'),
(2, 456, 'Joy', 'xxx', 'https://d1csarkz8obe9u.cloudfront.net/posterpreviews/action-thriller-book-cover-design-template-3675ae3e3ac7ee095fc793ab61b812cc_screen.jpg?ts=1637008457', 'xxx', 'reading', 0, 0, 'xxx', 'xxx');

insert into logs(id, OLid,book,shelf,content,date,mood,page)
values
(1,123, 'Life', 'xxx', 'test LIFE entry', 'xxx', 'xxx', 1),
(2,456, 'Joy', 'xxx', 'test JOY entry', 'xxx', 'xxx', 1);