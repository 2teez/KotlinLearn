#![allow(dead_code, unused)]

#[derive(Clone, Default, Debug, PartialEq)]
struct Book {
    title: String,
    author: String,
    is_avaliable: bool,
}

impl Book {
    fn new(title: &str, author: &str) -> Self {
        Self {
            title: title.to_string(),
            author: author.to_string(),
            is_avaliable: true,
        }
    }
}

#[derive(Clone, Default, Debug, PartialEq)]
struct BirthDate {
    month: u8,
    day: u8,
    year: u8,
}

#[derive(Clone, Default, Debug, PartialEq)]
struct Person {
    first_name: String,
    last_name: String,
    birth_day: BirthDate,
}

#[derive(Clone, Default, Debug, PartialEq)]
struct Member {
    person: Person,
    books: Vec<Book>,
}

impl Member {
    fn new() -> Self {
        Self {
            person: Person::default(),
            books: Vec::<Book>::new(),
        }
    }
    fn new_member<'a>(first_name: &'a str, last_name: &'a str) -> Self {
        Self {
            person: Person {
                first_name: first_name.to_string(),
                last_name: last_name.to_string(),
                birth_day: BirthDate::default(),
            },
            books: Vec::<Book>::new(),
        }
    }

    fn new_member_name(name: &str) -> Self {
        let trimmed = name.trim();
        //let mut names = Vec::new();
        if trimmed.contains(" ") {
            let names = trimmed.split_whitespace().collect::<Vec<_>>();
            return Self {
                person: Person {
                    first_name: names[0].to_string(),
                    last_name: names[1].to_string(),
                    birth_day: BirthDate::default(),
                },
                books: Vec::<Book>::new(),
            };
        } else {
            return Self {
                person: Person {
                    first_name: name.to_string(),
                    last_name: String::new(),
                    birth_day: BirthDate::default(),
                },
                books: Vec::<Book>::new(),
            };
        }
    }
}

#[derive(Debug)]
struct Library {
    books: Vec<Book>,
    members: Vec<Member>,
}

impl Library {
    fn new() -> Self {
        Self {
            books: Vec::<Book>::new(),
            members: Vec::<Member>::new(),
        }
    }

    fn add_member(&mut self, member: Member) {
        self.members.push(member)
    }

    fn find_member(&self, name: &str) -> Option<Member> {
        let pick = Member::new_member_name(name);
        for member in &self.members {
            if pick == *member {
                return Some(pick);
            }
        }
        None
    }

    fn add_a_book(&mut self, title: &str, author: &str) {
        self.books.push(Book {
            title: title.to_string(),
            author: author.to_string(),
            is_avaliable: true,
        });
    }
    fn borrow_book(&mut self, book_to_borrow: Book, member: &mut Member) -> bool {
        for book in &mut self.books {
            if book.is_avaliable && *book == book_to_borrow {
                member.books.push(book.clone());
                book.is_avaliable = false;
                return true;
            }
        }
        false
    }

    fn return_book(&mut self, book_to_return: Book, member: &mut Member) -> bool {
        for book in &mut self.books {
            if *book == book_to_return && !book.is_avaliable {
                book.is_avaliable = true;

                // Optional: also remove from member.books
                if let Some(pos) = member.books.iter().position(|b| *b == book_to_return) {
                    member.books.remove(pos);
                }

                return true;
            }
        }
        false
    }

    fn list_books(&self) {
        println!(
            "\n\nAVALIABLE BOOKS: {:?}",
            self.books
                .clone()
                .into_iter()
                .filter(|it| it.is_avaliable)
                .collect::<Vec<_>>()
        );
    }
}

fn main() {
    let mut lib = Library::new();
    lib.add_a_book("bible", "gideon");
    lib.add_a_book("prayer that moves mountains", "robert lensay");
    lib.add_a_book("god's general", "robert linsay");
    lib.add_a_book("new general mathematics", "cn port");

    // add members
    lib.add_member(Member::new_member_name("John Doe"));
    lib.add_member(Member::new_member_name("dorcas folorunso"));
    //lib.members.push(Member::new_member("Albert", "Esentin"));
    //println!("{:?}", lib);
    //
    let mut member = lib
        .find_member("dorcas folorunso")
        .unwrap_or_else(|| Member::new());
    //
    lib.borrow_book(Book::new("bible", "gideon"), &mut member);
    lib.borrow_book(Book::new("new general mathematics", "cn port"), &mut member);
    //
    lib.list_books();
    lib.return_book(Book::new("new general mathematics", "cn port"), &mut member);
    //
    lib.list_books();
}
