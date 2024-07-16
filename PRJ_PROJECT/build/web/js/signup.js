document.addEventListener("DOMContentLoaded", function() {
    const signupForm = document.getElementById('signup-form');

    if (signupForm) {
        signupForm.addEventListener('submit', function(e) {
            e.preventDefault();
            validateInputs(signupForm);
        });
    }
});

const validateInputs = (form) => {
    const form = document.getElementById('signup-form');  // Định nghĩa biến form
    const fullName = form.querySelector("#fullname");
    const username = form.querySelector("#username");
    const email = form.querySelector("#email");
    const password = form.querySelector("#password");
    const confirm_password = form.querySelector("#confirm_password");
    const telephone = form.querySelector("#telephone");

    const fullNameValue = fullName.value.trim();
    const usernameValue = username.value.trim();
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();
    const confirm_passwordValue = confirm_password.value.trim();
    const telephoneValue = telephone.value.trim();

    let valid = true;

    if (fullNameValue === '') {
        setError(fullName, 'Full Name is required');
        valid = false;
    } else if (!isValidFullName(fullNameValue)) {
        setError(fullName, 'Not contain numbers and special characters');
        valid = false;
    } else {
        setSuccess(fullName);
    }

    if (usernameValue === '') {
        setError(username, 'Username is required');
        valid = false;
    } else if (!isValidUserName(usernameValue)) {
        setError(username, 'Not contain special characters and spaces');
        valid = false;
    } else {
        setSuccess(username);
    }

    if (emailValue === '') {
        setError(email, 'Email is required');
        valid = false;
    } else if (!isValidEmail(emailValue)) {
        setError(email, 'Provide a valid email address');
        valid = false;
    } else {
        setSuccess(email);
    }

    if (passwordValue === '') {
        setError(password, 'Password is required');
        valid = false;
    } else if (!isValidPassword(passwordValue)) {
        setError(password, 'Password must be at least 8 characters, contain at least one letter and one number');
        valid = false;
    } else {
        setSuccess(password);
    }

    if (confirm_passwordValue === '') {
        setError(confirm_password, 'Please confirm your password');
        valid = false;
    } else if (passwordValue !== confirm_passwordValue) {
        setError(confirm_password, 'Passwords do not match');
        valid = false;
    } else {
        setSuccess(confirm_password);
    }

    if (telephoneValue === '') {
        setError(telephone, 'Telephone number is required');
        valid = false;
    } else if (!isValidTelephone(telephoneValue)) {
        setError(telephone, 'Provide a valid telephone number');
        valid = false;
    } else {
        setSuccess(telephone);
    }

    if (valid) {
        form.submit();
    }
}

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success')
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const isValidFullName = (fullName) => {
    return /^[a-zA-Z\s]+$/.test(fullName);
};

const isValidUserName = (username) => {
    return /^[a-zA-Z0-9]+$/.test(username);
};

const isValidEmail = (email) => {
    return /^\S+@\S+\.\S+$/.test(email);
};

const isValidPassword = (password) => {
    return /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/.test(password);
};

const isValidTelephone = (telephone) => {
    return /^\d{10,}$/.test(telephone);
};

const isValidAdminCode = (adminCode) => {
    return /^[a-zA-Z0-9]{6,}$/.test(adminCode);
};
