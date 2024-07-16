function changeType(button) {
    var inputElements = document.querySelectorAll(".input_type");
    if (button.id === "edit") {
        button.id = "save";
        button.textContent = "Save";
        inputElements.forEach(x => {
            if (x.name !== "username" && x.name !== "roleid") {
                x.readOnly = false;
            }
        });
    } else {
        if (validateProfileInputs()) {
            document.getElementById("form-edit").submit();
            button.id = "edit";
            button.textContent = "Edit";
            inputElements.forEach(x => {
                if (x.name !== "username" && x.name !== "roleid") {
                    x.readOnly = true;
                }
            });
        }
    }
}

function validateProfileInputs() {
    const form = document.getElementById('form-edit');
    const fullName = form.querySelector("input[name='fullname']");
    const address = form.querySelector("input[name='address']");
    const phone = form.querySelector("input[name='phone']");
    const email = form.querySelector("input[name='email']");

    const fullNameValue = fullName.value.trim();
    const addressValue = address.value.trim();
    const phoneValue = phone.value.trim();
    const emailValue = email.value.trim();

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

    if (addressValue === '') {
        setError(address, 'Address is required');
        valid = false;
    } else {
        setSuccess(address);
    }

    if (phoneValue === '') {
        setError(phone, 'Phone number is required');
        valid = false;
    } else if (!isValidTelephone(phoneValue)) {
        setError(phone, 'Provide a valid phone number');
        valid = false;
    } else {
        setSuccess(phone);
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

    return valid;
}

function setError(element, message) {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success');
}

function setSuccess(element) {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
}

function isValidFullName(fullName) {
    return /^[a-zA-Z\s]+$/.test(fullName);
}

function isValidTelephone(telephone) {
    return /^\d{10,}$/.test(telephone);
}

function isValidEmail(email) {
    return /^\S+@\S+\.\S+$/.test(email);
}

function confirmLogout() {
    if (confirm("Are you sure you want to log out?")) {
        window.location.href = "logout";
    }
}
