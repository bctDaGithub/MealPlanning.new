document.addEventListener("DOMContentLoaded", function() {
    const signupForm = document.getElementById('addAccount');

    if (signupForm) {
        signupForm.addEventListener('submit', function(e) {
            e.preventDefault();
            validateInputs(signupForm);
        });
    }
});

const validateInputs = (form) => {
    const username = form.querySelector("#username");
    const fullname = form.querySelector("#fullname");
    const email = form.querySelector("#email");
    const adress = form.querySelector("#adress");
    const password = form.querySelector("#password");
    const confirm_password = form.querySelector("#confirm_password");
    const telephone = form.querySelector("#telephone");
    const role = form.querySelector("#isAdmin");

    const usernameValue = username.value.trim();
    const fullnameValue = fullname.value.trim();
    const emailValue = email.value.trim();
    const adressValue = adress.value.trim();
    const passwordValue = password.value.trim();
    const confirm_passwordValue = confirm_password.value.trim();
    const telephoneValue = telephone.value.trim();
    const roleValue = role.checked ? "1" : "";

    let valid = true;

    if (usernameValue === '') {
        setError(username, 'Username is required');
        valid = false;
    } else if (!isValidUserName(usernameValue)) {
        setError(username, 'Username should not contain special characters or spaces');
        valid = false;
    } else {
        setSuccess(username);
    }

    if (fullnameValue === '') {
        setError(fullname, 'Full Name is required');
        valid = false;
    } else if (!isValidFullName(fullnameValue)) {
        setError(fullname, 'Full Name should not contain numbers or special characters');
        valid = false;
    } else {
        setSuccess(fullname);
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

    if (adressValue === '') {
        setError(adress, 'Address is required');
        valid = false;
    } else {
        setSuccess(adress);
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

    if (valid) {
        form.submit();
    }
};

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success');
};

const setSuccess = (element) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.remove('error');
    inputControl.classList.add('success');
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
