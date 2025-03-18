
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
// import 'package:my_first_flutter_project/APITEST/api_service.dart';

import 'dart:convert';
import 'package:http/http.dart' as http;

import 'api_service.dart';

class ApiDemo extends StatefulWidget {
  const ApiDemo({super.key});

  @override
  State<ApiDemo> createState() => _ApiDemoState();
}

class _ApiDemoState extends State<ApiDemo> {
  TextEditingController name = TextEditingController();
  TextEditingController email = TextEditingController();
  TextEditingController city = TextEditingController();
  List<dynamic> usersList = [];
  APIService apiService = APIService();

  @override
  void initState() {
    super.initState();
    fetchUsers();
  }

  Future<dynamic> fetchUsers() async {
    List<dynamic> users = [];
    users = await apiService.sendUsers();
    setState(() {
      usersList = users;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.black,
        title: Text(
          "API Demo",
          style: TextStyle(color: Colors.white, fontSize: 20),
        ),
      ),
      body: usersList.isEmpty
          ? Center(
        child: Text(
          "No data found",
          style:
          TextStyle(color: Colors.black, fontWeight: FontWeight.bold),
        ),
      )
          : ListView.builder(
        itemCount: usersList.length,
        itemBuilder: (context, index) {
          return Card(
            child: Row(
              children: [
                Expanded(
                  child: Column(
                    children: [
                      Text(
                        usersList[index]['name'],
                        style: TextStyle(fontSize: 15),
                      ),
                      Text(
                        usersList[index]['email'],
                        style: TextStyle(fontSize: 8),
                      ),
                      Text(
                        usersList[index]['city'],
                        style: TextStyle(fontSize: 8),
                      ),
                    ],
                  ),
                ),
                ElevatedButton(
                    onPressed: () {
                      name.text = usersList[index]['name'];
                      email.text = usersList[index]['email'];
                      city.text = usersList[index]['city'];
                      showDialog(
                        context: context,
                        builder: (context) {
                          return AlertDialog(
                            title: Text("Edit User"),
                            actions: [
                              Column(
                                children: [
                                  TextFormField(
                                    controller: name,
                                    decoration: InputDecoration(
                                        labelText: 'Enter user name',
                                        border: OutlineInputBorder(
                                            borderRadius:
                                            BorderRadius.circular(
                                                10))),
                                  ),
                                  SizedBox(
                                    height: 5,
                                  ),
                                  TextFormField(
                                    controller: email,
                                    decoration: InputDecoration(
                                        labelText: 'Enter user email',
                                        border: OutlineInputBorder(
                                            borderRadius:
                                            BorderRadius.circular(
                                                10))),
                                  ),
                                  SizedBox(
                                    height: 5,
                                  ),
                                  TextFormField(
                                    controller: city,
                                    decoration: InputDecoration(
                                        labelText: 'Enter user city',
                                        border: OutlineInputBorder(
                                            borderRadius:
                                            BorderRadius.circular(
                                                10))),
                                  ),
                                  SizedBox(
                                    height: 5,
                                  ),
                                  Row(
                                    children: [
                                      ElevatedButton(
                                          onPressed: () {
                                            Navigator.of(context).pop();
                                            name.clear();
                                            email.clear();
                                            city.clear();
                                          },
                                          child: Text("Cancel")),
                                      ElevatedButton(
                                          onPressed: () async {
                                            Map<String, dynamic>
                                            updatedUser = {
                                              'name':
                                              name.text.toString(),
                                              'email':
                                              email.text.toString(),
                                              'city':
                                              city.text.toString()
                                            };
                                            await apiService.updateUser(
                                                id: usersList[index]
                                                ['id'],
                                                map: updatedUser);
                                            Navigator.of(context).pop();
                                            name.clear();
                                            email.clear();
                                            city.clear();
                                            await fetchUsers();
                                          },
                                          child: Text("Update User"))
                                    ],
                                  )
                                ],
                              )
                            ],
                          );
                        },
                      );
                    },
                    child: Icon(
                      CupertinoIcons.pencil,
                      color: CupertinoColors.activeBlue,
                    )),
                ElevatedButton(
                    onPressed: () async {
                      apiService.deleteUser(
                          id: int.parse(usersList[index]['id']));
                      await fetchUsers();
                      setState(() {});
                    },
                    child: Icon(
                      Icons.delete,
                      color: Colors.red,
                    ))
              ],
            ),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          showDialog(
            context: context,
            builder: (context) {
              return AlertDialog(
                title: Text("Add User"),
                actions: [
                  Column(
                    children: [
                      TextFormField(
                        controller: name,
                        decoration: InputDecoration(
                            labelText: 'Enter user name',
                            border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10))),
                      ),
                      SizedBox(
                        height: 5,
                      ),
                      TextFormField(
                        controller: email,
                        decoration: InputDecoration(
                            labelText: 'Enter user email',
                            border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10))),
                      ),
                      SizedBox(
                        height: 5,
                      ),
                      TextFormField(
                        controller: city,
                        decoration: InputDecoration(
                            labelText: 'Enter user city',
                            border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10))),
                      ),
                      SizedBox(
                        height: 5,
                      ),
                      Row(
                        children: [
                          ElevatedButton(
                              onPressed: () {
                                Navigator.of(context).pop();
                              },
                              child: Text("Cancel")),
                          ElevatedButton(
                              onPressed: () async {
                                Map<String, dynamic> user = {};
                                user['name'] = name.text.toString();
                                user['email'] = email.text.toString();
                                user['city'] = city.text.toString();
                                apiService.addUser(map: user);
                                Navigator.of(context).pop();
                                name.clear();
                                email.clear();
                                city.clear();
                                await fetchUsers();
                                setState(() {});
                              },
                              child: Text("Add User"))
                        ],
                      )
                    ],
                  )
                ],
              );
            },
          );
        },
        child: Icon(Icons.add),
      ),
    );
  }
}

