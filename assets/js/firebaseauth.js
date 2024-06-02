// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/10.1.0/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/10.1.0/firebase-analytics.js";
import {
  getAuth,
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
  GoogleAuthProvider,
  signInWithRedirect,
  getRedirectResult,
  onAuthStateChanged,
  setPersistence,
  browserSessionPersistence,
  signOut,
} from "https://www.gstatic.com/firebasejs/10.1.0/firebase-auth.js";

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyCbf0LeMex9k1JkVYLEF72tlVUbAztU6Rc",
  authDomain: "thetipseason.firebaseapp.com",
  projectId: "thetipseason",
  storageBucket: "thetipseason.appspot.com",
  messagingSenderId: "987994279894",
  appId: "1:987994279894:web:b9b77c974a902068ec5e77",
  measurementId: "G-2VTGDC811Z",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

const auth = getAuth();
const googleProvider = new GoogleAuthProvider();

function toggleProfileSection(user) {
  if (user != null) {
    $("#username").text(user.email);
    $("#login").hide();
    $("#signup").hide();
    $("#profile").show();
  } else {
    $("#login").show();
    $("#signup").show();
    $("#profile").hide();
  }
}

export function checkAuthAndExecute(callbackIfAuthenticated) {
  // Set the state persistence to LOCAL
  setPersistence(auth, browserSessionPersistence)
    .then(() => {
      // Check authentication state
      onAuthStateChanged(auth, (user) => {
        if (user) {
          // User is signed in
          console.log("User is signed in:", user.email);
          console.log("User token:", user.getIdToken(true));
          // Update the page or show user-specific content here
          toggleProfileSection(user);
          // Execute callback function for authenticated user
          if (
            callbackIfAuthenticated &&
            typeof callbackIfAuthenticated === "function"
          ) {
            callbackIfAuthenticated(user);
          }
        } else {
          // User is signed out
          console.log("User is signed out.");
          // Redirect to the login page if the user is not authenticated
          window.location.href = "/login";
        }
      });
    })
    .catch((error) => {
      console.error("Error setting persistence: ", error.message);
    });
}

window.checkAuthAndExecute = checkAuthAndExecute;


// Handle logout on the logout page
const logoutButton = document.getElementById("logout"); // Replace with your element's ID

if (logoutButton) {
  logoutButton.addEventListener("click", () => {
    // Sign out the user
    signOut(auth)
      .then(() => {
        // User successfully signed out
        console.log("User signed out.");
        // Redirect to the login page or any other page you want
        window.location.href = "/login";
      })
      .catch((error) => {
        console.error("Logout error: ", error.message);
        // Handle logout error if needed
      });
  });
}
