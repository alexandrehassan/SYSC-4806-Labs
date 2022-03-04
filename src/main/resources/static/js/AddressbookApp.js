let count = 0;

function newAddressBook() {
    let input = document.getElementById('addressBookName').value;
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: '/AddressBook/new',
        dataType: "json",
        data: JSON.stringify({
            userName: input
        })
    });
    setTimeout(function () {
        count++;
        // addressBookIds.push(count);
        updateData();
    }, 1000);
}

function newBuddy() {
    let ABID_input = document.getElementById('aBID').value;
    let name_input = document.getElementById('buddyName').value;
    let phone_input = document.getElementById('buddyPhone').value;
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: '/AddressBook/addBuddy',
        dataType: "json",
        data: JSON.stringify({
            addressBookId: ABID_input,
            name: name_input,
            phone: phone_input
        })
    });
    setTimeout(function () {
        count++;
        updateData();
    }, 1000);

}

// function setAddressBookIDs(data) {
//     addressBookIds = data;
// }

// function getAddressBooks() {
//     $.ajax({
//         headers: {
//             'Accept': 'application/json',
//             'Content-Type': 'application/json'
//         },
//         type: "GET",
//         url: '/AddressBook',
//         dataType: "json",
//         success: function (data) {
//             setAddressBookIDs(data);
//         }
//     });
// }

function getIDs() {
    let addressBookIds = [];
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: '/AddressBook',
        dataType: "json",
        async: false,
        success: function (data) {
            data._embedded.AddressBook.forEach(function (addressBook) {
                console.log("80 " + addressBook.addressBookId);
                addressBookIds.push(addressBook.addressBookId);
            });
            return addressBookIds;
        }
    });
    // console.log("HELLO");
    console.log("86 " + addressBookIds);
    // console.log(addressBookIds[0]);

}

function updateData() {
    let test = getIDs();
    // console.log("93 " +test.length);
    // // for (let i = 0; i <test.length; i++) {
    // //     console.log(test[i]);
    // // }
    // console.log("97 " + test[0]);
    // console.log("98 " +test);
    $('#books').empty();
    $('#buddies').empty();

    test.forEach(getAddressBook);
}

function getAddressBook(value) {
    console.log("106 value: " + value);
    $.ajax({
        type: "GET",
        url: '/AddressBook/' + value,
        dataType: "json",
        success: function (data) {
            console.log(data);
            updateBook(data, value, data.numBuddies);
        }
    });
}

function updateBook(data, value, numBuddies) {
    $('#books').append(
        "<tr>" +
        "<td>" + data.userName + "</td>" +
        "<td>" + value + "</td>" +
        "</tr>"
    );
    getBuddies(value, numBuddies);
}


function getBuddies(value, numBuddies) {
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/AddressBook/' + value + '/buddies',
        dataType: "json",
        success: function (data) {
            updateBuddies(data, numBuddies);
        }
    });
}


function updateBuddies(data, numBuddies) {
    for (let i = 0; i < numBuddies; i++) {
        $('#buddies').append(
            "<tr>" +
            "<td>" + data._embedded.BuddyInfo[i].name + "</td>" +
            "<td>" + data._embedded.BuddyInfo[i].phone + "</td>" +
            "<td>" + data._embedded.BuddyInfo[i].addressBookId + "</td>" +
            "</tr>"
        );
    }
}