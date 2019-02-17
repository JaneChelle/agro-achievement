function checkPassword(){
    var pwd = $("#pwd1").val();
    gPasswdStatus(pwd,'p_PasswordStatus');
}
function gPasswdStatus(value,id){
    var status = $("#"+id);
    var result = $("#"+id).find(".status-result")[0];
    var bar = $("#"+id).find(".status-bar span");
    if (value === "") {
        status.css("display","none");
    } else {
        var score = gCheckPassword(value);
        bar.css("width",score + "%");
        var resultDesp = gGetResultDesp(score);
        result.innerHTML = resultDesp;
        status.css("display","block");
    }
}
/**
 * 检验密码强度并返回得分
 * 
 * @param {}
 *            password
 * @return {Number}
 */
function gCheckPassword(password) {
    var _score = 0;
    if (!password) {
        return 0
    }
    if (password.length <= 4) {
        _score += 5
    } else {
        if (password.length >= 5 && password.length <= 7) {
            _score += 10
        } else {
            if (password.length >= 8) {
                _score += 25
            }
        }
    }
    var _UpperCount = (password.match(/[A-Z]/g) || []).length;
    var _LowerCount = (password.match(/[a-z]/g) || []).length;
    var _LowerUpperCount = _UpperCount + _LowerCount;
    if (_UpperCount && _LowerCount) {
        _score += 20
    } else {
        if (_UpperCount || _LowerCount) {
            _score += 10
        }
    }
    var _NumberCount = (password.match(/[\d]/g, "") || []).length;
    if (_NumberCount > 0 && _NumberCount <= 2) {
        _score += 10
    } else {
        if (_NumberCount >= 3) {
            _score += 20
        }
    }
    var _CharacterCount = (password.match(/[!@#$%^&*?_\.\-~]/g) || []).length;
    if (_CharacterCount == 1) {
        _score += 10
    } else {
        if (_CharacterCount > 1) {
            _score += 25
        }
    }
    if (_NumberCount && (_UpperCount && _LowerCount)
            && _CharacterCount) {
        _score += 5
    } else {
        if (_NumberCount && _LowerUpperCount && _CharacterCount) {
            _score += 3
        } else {
            if (_NumberCount && _LowerUpperCount) {
                _score += 2
            }
        }
    }
    return _score
}
 /**
  * 根据密码强度得分返回密码强弱度中文提示
  * 
  * @param {}
  *            score
  * @return {String}
  */
 function gGetResultDesp(score) {
    if (score <= 5) {
        return "\u592a\u77ed"
    } else {
    if (score > 5 && score < 20) {
        return "\u5f31"
        } else {
        if (score >= 20 && score < 60) {
            return "\u4e2d"
        } else {
            if (score >= 60) {
                return "\u5f3a"
            } else {
                return ""
            }
            }
        }
    }
 }