
import 'dart:convert';

import 'package:http/http.dart' as http;

class APIService {
  String BaseURL = "https://67c6af62351c081993fe4aec.mockapi.io/mockdata";

  Future<dynamic> sendUsers() async {
    http.Response res = await http.get(Uri.parse(BaseURL));
    return convertDataToJSON(res);
  }

  Future<dynamic> deleteUser({id}) async {
    http.Response res = await http.delete(Uri.parse(BaseURL + '/$id'));
    return convertDataToJSON(res);
  }

  Future<dynamic> addUser({Map<String, dynamic>? map}) async {
    http.Response res = await http.post(Uri.parse(BaseURL), body: map);
    return convertDataToJSON(res);
  }

  Future<dynamic> updateUser({id, Map<String, dynamic>? map}) async {
    http.Response res = await http.put(Uri.parse(BaseURL + '/$id'), body: map);
    return convertDataToJSON(res);
  }

  dynamic convertDataToJSON(http.Response res) {
    if (res.statusCode == 200) {
      return jsonDecode(res.body);
    }
  }
}