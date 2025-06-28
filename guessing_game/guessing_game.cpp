#include <iostream>
#include <cstdlib>  // for rand() and srand()
#include <ctime>    // for time()

using namespace std;

int main() {
    // Seed random number generator
    srand(time(0));
    int secretNumber = rand() % 100 + 1; // Random number between 1 and 100

    int guess;
    int attempts = 0;

    cout << "🎯 Welcome to the Number Guessing Game!\n";
    cout << "I'm thinking of a number between 1 and 100.\n";

    do {
        cout << "Enter your guess: ";
        cin >> guess;
        attempts++;

        if (guess < secretNumber) {
            cout << "Too low! Try again.\n\n";
        } else if (guess > secretNumber) {
            cout << "Too high! Try again.\n\n";
        } else {
            cout << "🎉 Congratulations! You guessed the number in " << attempts << " attempts.\n";
        }
    } while (guess != secretNumber);

    return 0;
}
