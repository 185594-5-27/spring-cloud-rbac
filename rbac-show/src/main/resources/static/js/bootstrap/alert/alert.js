/*
 * 例子一：Ewin.alert({title:'提示',message:'你好啊'})
 * 例子二：Ewin.confirm({title:'提示',message:'是否要确定消息',width:500}).on(function (e) {if (!e) {return;}} );
 */
(function ($) {
    window.Ewin = function () {
        var html = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel" style="margin-top: 10px;">' +
            '<div class="modal-dialog ">' +
            '<div class="modal-content">' +
            '<div class="modal-header">' +
            '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>' +
            '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
            '</div>' +
            '<div class="modal-body">' +
            '<p>[Message]</p>' +
            '</div>' +
            '<div class="modal-footer">' +
            '<button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>' +
            '<button type="button" class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';


        var dialogdHtml = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel" style="margin-top: 10px;">' +
            '<div class="modal-dialog" >' +
            '<div class="modal-content" style="'+'width:[Width]px;height:[Height]px'+';">' +
            '<div class="modal-header">' +
            '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>' +
            '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
            '</div>' +
            '<div class="modal-body" style="height: [ModalHeight]px;overflow-y:auto; ">' +
            '</div>' +
            '<div class="modal-footer" >' +
            '<button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>' +
            '<button type="button" class="btn btn-primary ok" id="btnOk" data-dismiss="modal">确定</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';

        var dialogShowHtml = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel" style="margin-top: 10px;">' +
            '<div class="modal-dialog" >' +
            '<div class="modal-content" style="'+'width:[Width]px;height:[Height]px'+';">' +
            '<div class="modal-header">' +
            '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>' +
            '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
            '</div>' +
            '<div class="modal-body" style="height: [ModalHeight]px;overflow-y:auto; ">' +
            '<iframe style="width:100%;height:100%;border:none;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes" src="[url]" ></iframe>' +
            '</div>' +
            '<div class="modal-footer" >' +
            '<button type="button" class="btn btn-default cancel" data-dismiss="modal">关闭</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';

        var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
        var generateId = function () {
            var date = new Date();
            return 'mdl' + date.valueOf();
        }
        var init = function (options) {
            options = $.extend({}, {
                title: "操作提示",
                message: "提示内容",
                btnok: "确定",
                btncl: "取消",
                width: 200,
                auto: false
            }, options || {});
            var modalId = generateId();
            var content = html.replace(reg, function (node, key) {
                return {
                    Id: modalId,
                    Title: options.title,
                    Message: options.message,
                    BtnOk: options.btnok,
                    BtnCancel: options.btncl
                }[key];
            });
            $('body', window.top.document).append(content);
            $('body', window.top.document).append("<div class='modal-backdrop fade in' ></div>");
            $('#' + modalId, window.top.document).modal({
                width: options.width,
                backdrop: 'static'
            });
            $('#' + modalId, window.top.document).on('hide.bs.modal', function (e) {
                $('body', window.top.document).find('.modal-backdrop').remove();
                $('body', window.top.document).find('#' + modalId).remove();
            });
            $('body').find('.modal-backdrop').removeClass('modal-backdrop')
            return modalId;
        }

        return {
            alert: function (options) {
                if (typeof options == 'string') {
                    options = {
                        message: options
                    };
                }
                var id = init(options);
                var modal = $('#' + id, window.top.document);
                modal.find('.ok').removeClass('btn-success').addClass('btn-primary');
                modal.find('.cancel').hide();

                return {
                    id: id,
                    on: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.find('.ok').click(function () { callback(true); });
                        }
                    },
                    hide: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.on('hide.bs.modal', function (e) {
                                callback(e);
                            });
                        }
                    }
                };
            },
            confirm: function (options) {
                var id = init(options);
                var modal = $('#' + id, window.top.document);
                modal.find('.ok').removeClass('btn-primary').addClass('btn-success');
                modal.find('.cancel').show();
                return {
                    id: id,
                    on: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.find('.ok').click(function () { callback(true); });
                            modal.find('.cancel').click(function () { callback(false); });
                        }
                    },
                    hide: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.on('hide.bs.modal', function (e) {
                                callback(e);
                            });
                        }
                    }
                };
            },
            dialog: function (options) {
                options = $.extend({}, {
                    title: 'title',
                    url: '',
                    width: 800,
                    height: 550,
                    gridId: '',
                    onReady: function () { },
                    onShown: function (e) { },
                    onSubmit:function(){
                        return false;
                    }
                }, options || {});
                var modalId = generateId();
                var gridId = options.gridId;
                options.onSubmit = function(){
                    return false;
                }

                var content = dialogdHtml.replace(reg, function (node, key) {
                    return {
                        Id: modalId,
                        Title: options.title,
                        Width : options.width,
                        Height : options.height,
                        ModalHeight :options.height - 130
                    }[key];
                });
                $('body', window.top.document).append(content);
                $('body', window.top.document).append("<div class='modal-backdrop fade in' ></div>");
                var target = $('#' + modalId, window.top.document);
                target.find('.modal-body').load(options.url);
                if (options.onReady())
                    options.onReady.call(target);
                target.modal();
                target.on('shown.bs.modal', function (e) {
                    if (options.onReady(e)){
                        options.onReady.call(target, e);
                    }
                });
                target.on('hide.bs.modal', function (e) {
                    $('body', window.top.document).find(target).remove();
                    $('body', window.top.document).find('.modal-backdrop').remove();
                });
                $('body').find('.modal-backdrop').removeClass('modal-backdrop');
                $('body', window.top.document).find('.modal-footer').find('.btn-primary').bind('click',options.onSubmit);
               // alert($('body', window.top.document).find('.modal-footer').html())
            },
            dialogShow: function (options) {
                options = $.extend({}, {
                    title: 'title',
                    url: '',
                    width: 800,
                    height: 550,
                    gridId: '',
                    onReady: function () { },
                    onShown: function (e) { },
                    onSubmit:function(){
                        return false;
                    }
                }, options || {});
                var modalId = generateId();
                var gridId = options.gridId;
                options.onSubmit = function(){
                    return false;
                }

                var content = dialogShowHtml.replace(reg, function (node, key) {
                    return {
                        Id: modalId,
                        Title: options.title,
                        Width : options.width,
                        Height : options.height,
                        ModalHeight :options.height - 130,
                        url:options.url
                    }[key];
                });
                $('body', window.top.document).append(content);
                $('body', window.top.document).append("<div class='modal-backdrop fade in' ></div>");
                var target = $('#' + modalId, window.top.document);
                $('#' + modalId, window.top.document).modal({
                    url: options.url,
                    backdrop: 'static'
                });
                $('#' + modalId, window.top.document).on('hide.bs.modal', function (e) {
                    $('body', window.top.document).find('.modal-backdrop').remove();
                    $('body', window.top.document).find('#' + modalId).remove();
                });
                $('body').find('.modal-backdrop').removeClass('modal-backdrop');
                // alert($('body', window.top.document).find('.modal-footer').html())
            }
        }
    }();
})(jQuery);