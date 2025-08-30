macro_rules! pp {
    ($msg: expr, $f: expr) => {{
        print!("{}", $msg);
        println!("{}", $f());
    }};
}

fn main() {
    let say_hello = || {
        println!("Hello, World!");
    };
    say_hello();
    //
    let mut fc = kounter(0);
    let mut sc = kounter(0);
    println!("{}", fc());
    println!("{}", fc());
    println!("{}", fc());
    println!("{}", sc());
    println!("{}", fc());
    println!("{}", sc());
    pp!("Second Counter -> ", sc);
    pp!("First Counter -> ", fc);
}

fn kounter(mut count: i32) -> impl FnMut() -> i32 {
    move || {
        count += 1;
        count
    }
}
